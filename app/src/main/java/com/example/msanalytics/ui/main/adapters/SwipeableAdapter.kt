package com.example.msanalytics.ui.main.adapters

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.scale
import androidx.recyclerview.widget.RecyclerView
import com.example.msanalytics.R
import com.example.msanalytics.databinding.FragmentSwipeableFeedBinding
import com.example.msanalytics.ui.main.swipeable_feed.SwipeableFeedFragment
import com.example.msanalytics.ui.main.swipeable_feed.SwipeableFeedViewModel


class SwipeableAdapter (
    private val binding: FragmentSwipeableFeedBinding,
    private val swipeableFeedItems: List<SwipeableFeedViewModel>
) : RecyclerView.Adapter<SwipeableAdapter.ImageViewHolder>() {

    class ImageViewHolder (
        v: View, val binding: FragmentSwipeableFeedBinding
    ): RecyclerView.ViewHolder(v) {
        fun setSwipeableFeedData(swipeableFeedData: SwipeableFeedViewModel) {
            val imageBackground = binding.fragmentSwipeableFeedImage
            val textTitle = binding.fragmentSwipeableFeedTitle
            val textDescription = binding.fragmentSwipeableFeedDescription
            val processBar = binding.fragmentSwipeableFeedProgressBar
            val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length)
            imageBackground
                .setImageBitmap(Bitmap.createScaledBitmap(
                    bmp, imageBackground.width, imageBackground.height, false
                ))
            if (imageBackground.isAttachedToWindow) {
                processBar.visibility = View.GONE
            }
        }
    }

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.id.fragment_swipeable_feed__image, parent
            ), binding
        )
    }

    override fun getItemCount(): Int {
        return swipeableFeedItems.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.setSwipeableFeedData(swipeableFeedItems.get(position))
    }
}