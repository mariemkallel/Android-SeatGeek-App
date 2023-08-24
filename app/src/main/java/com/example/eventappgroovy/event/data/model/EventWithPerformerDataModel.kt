package com.example.eventappgroovy.event.data.model

class EventWithPerformerDataModel (
    val event : EventDataModel,
    val performers : List<PerformerDataModel> = emptyList()
)