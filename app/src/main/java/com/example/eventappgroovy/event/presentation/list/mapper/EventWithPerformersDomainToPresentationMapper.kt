package com.example.eventappgroovy.event.presentation.list.mapper

import com.example.eventappgroovy.event.domain.model.EventWithPerformersDateFormattedDomainModel
import com.example.eventappgroovy.event.domain.model.EventWithPerformersDomainModel
import com.example.eventappgroovy.event.presentation.list.model.EventWithPerformerPresentationModel
import com.example.eventappgroovy.performer.domain.model.PerformerDomainModel

object EventWithPerformersToPresentationMapper {
    fun map(eventWithPerformers: EventWithPerformersDateFormattedDomainModel): EventWithPerformerPresentationModel {
        return EventWithPerformerPresentationModel(
            id = eventWithPerformers.event.event.id,
            type = eventWithPerformers.event.event.type,
            datetimeLocal = eventWithPerformers.event.event.datetimeLocal,
            shortTitle = eventWithPerformers.event.event.shortTitle,
            formattedDate= eventWithPerformers.event.formattedDateTime,
            performers = eventWithPerformers.performers,
        )
    }
}
