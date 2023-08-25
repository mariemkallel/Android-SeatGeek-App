package com.example.eventappgroovy.event.domain.model

import com.example.eventappgroovy.performer.domain.model.PerformerDomainModel

data class EventWithPerformersDomainModel(
    val event: EventDomainModel,
    val performers: List<PerformerDomainModel>
)data class EventWithPerformersDateFormattedDomainModel(
    val event: EventDomainModelWithFormattedDate,
    val performers: List<PerformerDomainModel>
)