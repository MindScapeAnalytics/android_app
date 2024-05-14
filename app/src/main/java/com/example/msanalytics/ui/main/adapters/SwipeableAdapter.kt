package com.example.msanalytics.ui.main.adapters

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.msanalytics.R
import com.example.msanalytics.data.api.retrofit.backend.models.serialization.SerializationService
import com.example.msanalytics.data.repository.EventRepository
import com.example.msanalytics.ui.main.converters.Converter
import com.example.msanalytics.ui.main.models.SwipeableFeedModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


class SwipeableAdapter (
    private val v: View
) : RecyclerView.Adapter<SwipeableAdapter.ImageViewHolder>() {
    private var swipeableFeedItems: List<SwipeableFeedModel> = ArrayList()
    class ImageViewHolder constructor(
        v: View
    ): RecyclerView.ViewHolder(v) {
        private var imageBackground: ImageView
        private var textTitle: TextView
        private var textDescription: TextView
        private var processBar: ProgressBar
        init {
            imageBackground = v.findViewById(R.id.item_swipeable_feed__image)
            textTitle = v.findViewById(R.id.item_swipeable_feed__title)
            textDescription = v.findViewById(R.id.item_swipeable_feed__description)
            processBar = v.findViewById(R.id.item_swipeable_feed__progress_bar)
        }
        fun setSwipeableFeedData(swipeableFeedData: SwipeableFeedModel) {
            textTitle.text = swipeableFeedData.title
            textDescription.text = swipeableFeedData.description
            imageBackground
                .setImageBitmap(
                    Converter().StringToBitMap(swipeableFeedData.image)?.let {
                        Bitmap.createScaledBitmap(
                            it, imageBackground.width, imageBackground.height, false
                        )
                    }
                )
            if (imageBackground.isAttachedToWindow) {
                processBar.visibility = View.GONE
            }
        }
    }

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_swipeable_feed, parent, false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapterData(newEventList: ArrayList<SwipeableFeedModel>) {
        swipeableFeedItems = newEventList; notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return swipeableFeedItems.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.setSwipeableFeedData(swipeableFeedItems[position])
        /*if (swipeableFeedItems[position] == swipeableFeedItems.last()) {
            CoroutineScope(Dispatchers.Main + SupervisorJob()).launch {
                updateAdapterData(
                    SerializationService()
                        .backendEventModelToSwipeableFeedModelList(
                            repository.getEvents().body()
                        ))
            }
        }*/
        holder.itemView.setOnClickListener { view ->
            val bundle = Bundle()
            bundle.putSerializable("data", swipeableFeedItems[position])
            view.findNavController().navigate(R.id.eventFragment, bundle)
        }
    }

}