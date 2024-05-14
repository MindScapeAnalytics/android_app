package com.example.msanalytics.ui.main.event

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.msanalytics.databinding.FragmentEventCreateBinding
import com.example.msanalytics.ui.main.converters.Converter
import com.example.msanalytics.ui.main.models.SwipeableFeedModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventCreateFragment : Fragment() {
    private val viewModel: EventCreateViewModel by viewModels()
    private lateinit var fragmentEventCreateBinding: FragmentEventCreateBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private val _setImage: MutableLiveData<String> = MutableLiveData()
    val setImage: LiveData<String> get() = _setImage
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentEventCreateBinding = FragmentEventCreateBinding.inflate(layoutInflater); registerResult()
        fragmentEventCreateBinding.fragmentEventCreateImage.setOnClickListener {
            pickImage()
        }
        fragmentEventCreateBinding.fragmentEventCreateSaveButton.setOnClickListener {
            setImage.observe(viewLifecycleOwner) {
                viewModel.createEvent(
                    fragmentEventCreateBinding.fragmentEventCreateEventName.text.toString(),
                    fragmentEventCreateBinding.fragmentEventCreateEventCategory.text.toString(),
                    it
                )
            }
        }
        return fragmentEventCreateBinding.root
    }

    fun pickImage() {
        val intent: Intent = Intent(MediaStore.ACTION_PICK_IMAGES)
        resultLauncher.launch(intent)
    }

    @SuppressLint("ShowToast")
    fun registerResult() {
        resultLauncher =
            registerForActivityResult(
                ActivityResultContracts.StartActivityForResult(),
                ActivityResultCallback {result ->
                    try {
                        val imageUri: Uri? = result.data?.data
                        fragmentEventCreateBinding.fragmentEventCreateImage.setImageURI(imageUri)
                        val bitmap =
                            MediaStore.Images.Media.getBitmap(requireContext().contentResolver, imageUri)
                        _setImage.postValue(Converter().bitmapToString(bitmap))
                    } catch (e: Exception) {
                         Toast.makeText(requireContext(), "No Image Selected", Toast.LENGTH_SHORT).show()
                    }
                }
            )
    }
}