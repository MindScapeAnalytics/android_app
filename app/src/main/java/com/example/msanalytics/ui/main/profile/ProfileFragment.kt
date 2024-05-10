package com.example.msanalytics.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.msanalytics.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels()
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)

//        viewModel.images.observe(viewLifecycleOwner) {
//            it.forEach { image ->
//                Log.i("image", image.displayName)
//            }
//        }
//
//        binding.fragmentProfileAvatar.setOnClickListener {
//
//        }
        return binding.root
    }

}