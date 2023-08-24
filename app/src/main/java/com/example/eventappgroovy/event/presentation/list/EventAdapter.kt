package com.example.eventappgroovy.event.presentation.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.eventappgroovy.databinding.ItemEventBinding
import com.example.eventappgroovy.event.presentation.list.model.EventPresentationModel
import com.example.eventappgroovy.event.presentation.list.model.EventWithPerformerPresentationModel


class EventAdapter : ListAdapter<EventWithPerformerPresentationModel, EventViewHolder>(EventDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEventBinding.inflate(inflater, parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


class EventViewHolder(private val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: EventWithPerformerPresentationModel) {
        binding.eventTitleTextView.text = item.shortTitle
        binding.eventDateTimeTextView.text = item.datetimeLocal
        binding.eventTitleTextView.text=item.type
        //binding.eventTitleTextView.text=item.image_attribution
//        Glide.with(binding.eventImageView.context)
//            .load(item.image_attribution) // Load image from the provided URL
//            .centerCrop()
//            .transform(RoundedCorners(8)) // Apply rounded corners
//            .into(binding.eventImageView)
        val performers = item.performers.joinToString(", ") { it.name }
        binding.performersTextView.text = performers
    }
}
class EventDiffCallback : DiffUtil.ItemCallback<EventWithPerformerPresentationModel>() {
    override fun areItemsTheSame(oldItem: EventWithPerformerPresentationModel, newItem: EventWithPerformerPresentationModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: EventWithPerformerPresentationModel, newItem: EventWithPerformerPresentationModel): Boolean {
        return oldItem == newItem
    }
}
