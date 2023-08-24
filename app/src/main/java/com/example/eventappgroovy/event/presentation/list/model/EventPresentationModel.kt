package com.example.eventappgroovy.event.presentation.list.model

data class EventPresentationModel(
    val id :Long,
    val type: String,
    val datetimeLocal: String,
    val shortTitle: String
)