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
    val image_attribution :String = "https://www.flickr.com/photos/ryanthescooterguy/24449820446/in/photolist-2mWk2sK-2mG6nvz-6kWq7y-DfxHNo-2orqvZ5-2ngHady-2nfTLXB-2ojsTS9-2os33CA-2nBZbF2-2ooGokH-2owEKmF-2nDX8mx-2nH9tc2-2opawz2-2otjVpm-2ny7qsZ-2osW7v4-2ovAJuZ-2nvzX7Z-2ni8mB7-2nnHqnW-2nxR3pn-2nvdo6F-2nuky3s-2nCeQZq-2nqSAB5-2nEu8pu-2njeQ11-2mwnR34-2nByGHa-2n2hypX-2mTDtiC-2ohBRdC-R254SB-2mU6jZg-2na6nKD-2nCrdMN-2nKraCD-2mMHxpk-2mEBx6t-2mWJ8KD-2nHytTn-2mSB2P3-dcvove-2mFAbSt-2mtuQzg",
    //val stats: Stats,
    //val taxonomies: List<Taxonomy>,
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