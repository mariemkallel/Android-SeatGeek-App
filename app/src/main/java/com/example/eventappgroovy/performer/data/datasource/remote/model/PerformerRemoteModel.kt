package com.example.eventappgroovy.event.data.datasource.remote.model

import android.provider.MediaStore

data class PerformerRemoteModel (
    val type: String,
    val name: String,
    val image: String,
    val id: Long,
    val images: MediaStore.Images,
    val divisions: Any?, // Change to appropriate type if applicable
    val has_upcoming_events: Boolean,
    val primary: Boolean,
    //val stats: Stats,
    //val taxonomies: List<Taxonomy>,
    val image_attribution: String,
    val url: String,
    val score: Double,
    val slug: String,
    val home_venue_id: Int, // Change to appropriate type if applicable
    val short_name: String,
    val num_upcoming_events: Int,
    val colors: Any?, // Change to appropriate type if applicable
    val image_license: String,
    //val genres: List<Genre>,
    val popularity: Int,
    val location: Any?, // Change to appropriate type if applicable
    val image_rights_message: String
)