package com.example.eventappgroovy.event.data

import com.example.eventappgroovy.event.data.model.EventDataModel
import com.example.eventappgroovy.event.data.model.EventWithPerformerDataModel


interface EventRepository {
    suspend fun getEvents(clientId: String): List<EventDataModel>
    suspend fun getEventDetails(eventId: Long,clientId: String): EventDataModel
    suspend fun getEventsWithPerformers(clientId: String): List<EventWithPerformerDataModel>

}
