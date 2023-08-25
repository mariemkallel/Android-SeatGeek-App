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
        val date ="Date: ${item.formattedDate}"
        binding.eventDateTimeTextView.text = date
        binding.eventTypeTagTextView.text=item.type
        Glide.with(binding.eventImageView.context)
            .load("https://www.flickr.com/photos/ryanthescooterguy/24449820446/in/photolist-2mWk2sK-2mG6nvz-6kWq7y-DfxHNo-2orqvZ5-2ngHady-2nfTLXB-2ojsTS9-2os33CA-2nBZbF2-2ooGokH-2owEKmF-2nDX8mx-2nH9tc2-2opawz2-2otjVpm-2ny7qsZ-2osW7v4-2ovAJuZ-2nvzX7Z-2ni8mB7-2nnHqnW-2nxR3pn-2nvdo6F-2nuky3s-2nCeQZq-2nqSAB5-2nEu8pu-2njeQ11-2mwnR34-2nByGHa-2n2hypX-2mTDtiC-2ohBRdC-R254SB-2mU6jZg-2na6nKD-2nCrdMN-2nKraCD-2mMHxpk-2mEBx6t-2mWJ8KD-2nHytTn-2mSB2P3-dcvove-2mFAbSt-2mtuQzg") // Load image from the provided URL
            .centerCrop()
            .transform(RoundedCorners(8)) // Apply rounded corners
            .into(binding.eventImageView)
        val performers = "Performers: ${item.performers.joinToString(", ") { it.name }}"

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
