package com.example.eventappgroovy.event.data.datasource.remote.model


data class Location(val lat: Double, val lon: Double)
data class VenueRemoteModel (
    val state: String,
    val name_v2: String,
    val address : String,
    val postal_code: String,
    val name: String,
    val links: List<String>,
    val timezone: String,
    val url: String,
    val score: Double,
    val location: Location

)