package com.example.eventappgroovy.event.domain.mapper

import com.example.eventappgroovy.event.data.model.EventWithPerformerDataModel
import com.example.eventappgroovy.event.domain.model.EventWithPerformersDomainModel
import com.example.eventappgroovy.performer.domain.mapper.PerformerDataToDomainMapper
import javax.inject.Inject

class EventWithPerformerDataToDomainMapper @Inject constructor(
    private val performerMapper: PerformerDataToDomainMapper,
    private val eventMapper: EventDataToDomainMapper
) {
    fun map(input: EventWithPerformerDataModel): EventWithPerformersDomainModel {
        val eventDomain = eventMapper.map(input.event)
        val performersDomain = input.performers.map { performerMapper.map(it) }

        return EventWithPerformersDomainModel(
            event = eventDomain,
            performers = performersDomain
        )
    }
}



