package com.example.eventappgroovy.event.domain.usecase

import android.util.Log
import com.example.eventappgroovy.event.data.EventRepository
import com.example.eventappgroovy.event.data.model.EventDataModel
import com.example.eventappgroovy.event.domain.mapper.EventDataToDomainMapper
import com.example.eventappgroovy.event.domain.mapper.EventWithPerformerDataToDomainMapper
import com.example.eventappgroovy.event.domain.model.EventDomainModel
import com.example.eventappgroovy.event.domain.model.EventWithPerformersDateFormattedDomainModel
import com.example.eventappgroovy.event.domain.model.EventWithPerformersDomainModel
import com.example.eventappgroovy.performer.data.PerformerRepository
import com.example.eventappgroovy.performer.domain.mapper.PerformerDataToDomainMapper
import javax.inject.Inject
//
//class GetEventsUseCase @Inject constructor(
//    private val eventRepository: EventRepository,
//    private val eventWithPerformerDataToDomainMapper: EventWithPerformerDataToDomainMapper
//) {
//
//    suspend fun invoke(clientId: String): List<EventWithPerformersDomainModel> {
//        val remoteEventsWithPerformers = eventRepository.getEventsWithPerformers(clientId)
//
//        return remoteEventsWithPerformers.map { remoteEventWithPerformers ->
//            eventWithPerformerDataToDomainMapper.map(remoteEventWithPerformers)
//        }
//    }
class GetEventsUseCase @Inject constructor(
    private val eventRepository: EventRepository,
    private val eventWithPerformerDataToDomainMapper: EventWithPerformerDataToDomainMapper,

    ) {

    suspend fun invoke(clientId: String): List<EventWithPerformersDateFormattedDomainModel> {
        val remoteEventsWithPerformers = eventRepository.getEventsWithPerformers(clientId)

        return remoteEventsWithPerformers.map { remoteEventWithPerformers ->
            eventWithPerformerDataToDomainMapper.mapWithFormattedDate(remoteEventWithPerformers)
        }
    }
}

