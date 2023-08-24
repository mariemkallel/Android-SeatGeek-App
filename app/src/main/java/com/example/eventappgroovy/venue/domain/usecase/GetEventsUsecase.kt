package com.example.eventappgroovy.event.domain.usecase

import com.example.eventappgroovy.event.domain.mapper.EventDataToDomainMapper
import com.example.eventappgroovy.event.domain.model.EventDomainModel
import javax.inject.Inject


//class GetVenueUseCase @Inject constructor(
//    private val venueRepository: VenueRepository,
//    private val venueDataToDomainMapper: venueDataToDomainMapper
//) {
//
//    suspend operator fun invoke(clientId: String): List<EventDomainModel> {
//        val eventDataList = eventRepository.getEvents(clientId)
//        return eventDataList.map { eventData ->
//            eventDataToDomainMapper.map(eventData)
//        }
//    }
//}
