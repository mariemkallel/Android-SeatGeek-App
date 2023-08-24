package com.example.eventappgroovy.event.presentation.list.mapper

import com.example.eventappgroovy.event.domain.model.EventWithPerformersDomainModel
import com.example.eventappgroovy.event.presentation.list.model.EventWithPerformerPresentationModel
import com.example.eventappgroovy.performer.domain.model.PerformerDomainModel

object EventWithPerformersToPresentationMapper {
    fun map(eventWithPerformers: EventWithPerformersDomainModel): EventWithPerformerPresentationModel {
        return EventWithPerformerPresentationModel(
            id = eventWithPerformers.event.id,
            type = eventWithPerformers.event.type,
            datetimeLocal = eventWithPerformers.event.datetimeLocal,
            shortTitle = eventWithPerformers.event.shortTitle,
            performers = eventWithPerformers.performers,
           // image_attribution=eventWithPerformers.event.image_attribution
        )
    }
}
