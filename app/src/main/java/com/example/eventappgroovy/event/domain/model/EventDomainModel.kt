package com.example.eventappgroovy.event.domain.model


data class EventDomainModel(
    val id: Long,
    val type: String,
    val datetimeLocal: String,
    val shortTitle: String
)