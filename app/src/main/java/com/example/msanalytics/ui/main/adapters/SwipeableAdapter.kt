package com.example.msanalytics.ui.main.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.msanalytics.R
import com.example.msanalytics.databinding.ItemSwipeableFeedBinding
import com.example.msanalytics.ui.main.models.SwipeableFeedModel
import com.example.msanalytics.ui.main.swipeable_feed.SwipeableFeedViewModel


class SwipeableAdapter (
    private val swipeableFeedItems: List<SwipeableFeedModel>,
    private val v: View
) : RecyclerView.Adapter<SwipeableAdapter.ImageViewHolder>() {

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
//            val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length)
//            imageBackground
//                .setImageBitmap(Bitmap.createScaledBitmap(
//                    bmp, imageBackground.width, imageBackground.height, false
//                ))
//            if (imageBackground.isAttachedToWindow) {
//                processBar.visibility = View.GONE
//            }
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

    override fun getItemCount(): Int {
        return swipeableFeedItems.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.setSwipeableFeedData(swipeableFeedItems[position])
        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(R.id.eventFragment)
        }
    }

}