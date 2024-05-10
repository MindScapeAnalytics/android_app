package com.example.msanalytics.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.msanalytics.R
import com.example.msanalytics.ui.main.models.EventParticipantsFeedModel

class EventAdapter (
    private val eventParticipantsFeedItems: List<EventParticipantsFeedModel>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class EventParticipantsViewHolder constructor(
        v: View
    ): RecyclerView.ViewHolder(v) {
        private var imageAvatar: ImageView
        private var textName: TextView
        init {
            imageAvatar = v.findViewById(R.id.item_event_participants__image)
            textName = v.findViewById(R.id.item_event_participants__text)
        }
        fun setEventParticipantsFeedData(eventParticipantsFeedData: EventParticipantsFeedModel) {
            textName.text = eventParticipantsFeedData.text
            /*добавить аватар*/
        }
    }

    class EventAddParticipantsViewHolder constructor(
        v: View
    ): RecyclerView.ViewHolder(v) {
        private var imageButton: ImageView
        private var textDescription: TextView
        init {
            imageButton = v.findViewById(R.id.item_event_add_participants__button)
            textDescription = v.findViewById(R.id.item_event_add_participants__text)
        }
        fun setEventAddParticipantsFeedData() {
            imageButton.setImageResource(R.drawable.ic_add_circle)
            textDescription.text = "Вы можете забронировать себе место"
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            EventParticipantsFeedModel().FIRST_TYPE -> EventAddParticipantsViewHolder (
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_event_add_participants, parent, false
                )
            )
            EventParticipantsFeedModel().SECOND_TYPE -> EventParticipantsViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_event_participants, parent, false
                )
            )
            else -> EventParticipantsViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_event_participants, parent, false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return eventParticipantsFeedItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (eventParticipantsFeedItems[position].type) {
            EventParticipantsFeedModel().FIRST_TYPE -> {
                (holder as EventAddParticipantsViewHolder).setEventAddParticipantsFeedData()
            }
            EventParticipantsFeedModel().SECOND_TYPE -> {
                (holder as EventParticipantsViewHolder).setEventParticipantsFeedData(eventParticipantsFeedItems[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (eventParticipantsFeedItems[position].type) {
            0 -> EventParticipantsFeedModel().FIRST_TYPE
            1 -> EventParticipantsFeedModel().SECOND_TYPE
            else -> -1
        }
    }
}