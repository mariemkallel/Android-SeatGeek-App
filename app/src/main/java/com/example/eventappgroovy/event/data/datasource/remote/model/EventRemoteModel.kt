package com.example.eventappgroovy.event.data.datasource.remote.model


    data class EventRemoteModel (
        val type: String,
        val id: Long,
        val datetime_utc: String,
        val venue: VenueRemoteModel,
        val datetime_tbd: Boolean,
        val performers: List<PerformerRemoteModel>,
        val is_open: Boolean,
        val datetime_local: String,
        val time_tbd: Boolean,
        val short_title: String,
        val visible_until_utc: String,
        //val image_attribution : String,
        //val stats: StatsRemoteModel,
        //val taxonomies: List<TaxonomyRemoteModel>,
        val url: String,
        val score: Double,
        val announce_date: String,
        val created_at: String,
        val date_tbd: Boolean,
        val title: String,
        val popularity: Double,
        val description: String,
        val status: String,
        //val access_method: AccessMethodRemoteModel,
        val event_promotion: String?,
        val announcements: Map<String, Any>,
        val conditional: Boolean,
        val enddatetime_utc: String?,
        val visible_at: String,
        val is_visible_override: String,
        val tdc_pvo_id: Int,
        val tdc_pv_id: Int,
        val is_visible: Boolean,
        val themes: List<String>,
        val domain_information: List<String>
    )

data class EventListResponse(
    val events: List<EventRemoteModel>,
    val meta: MetaData
)
data class MetaData(
    val total: Int,
    val took: Int,
    val page: Int,
    val per_page: Int,
    val geolocation: String? // You might need to adjust the type
)
