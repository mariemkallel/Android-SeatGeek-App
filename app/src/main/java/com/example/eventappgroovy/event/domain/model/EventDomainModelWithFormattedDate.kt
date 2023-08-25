package com.example.eventappgroovy.event.domain.model

data class EventDomainModelWithFormattedDate(
    val event: EventDomainModel,
    val formattedDateTime: String
)