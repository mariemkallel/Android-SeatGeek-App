package com.example.eventappgroovy.event.data

import android.util.Log
import com.example.eventappgroovy.event.data.datasource.remote.EventRemoteDataSource
import com.example.eventappgroovy.event.data.mapper.EventPerformerRemoteToDataMapper
import com.example.eventappgroovy.event.data.mapper.EventRemoteToDataMapper
import com.example.eventappgroovy.event.data.model.EventDataModel
import com.example.eventappgroovy.event.data.model.EventWithPerformerDataModel
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val eventRemoteDataSource: EventRemoteDataSource,
    private val eventRemoteToDataMapper: EventRemoteToDataMapper,
    private val eventPerformerRemoteToDataMapper:EventPerformerRemoteToDataMapper,

) : EventRepository {

    override suspend fun getEvents(clientId: String): List<EventDataModel> {
        val remoteEvents = eventRemoteDataSource.getEvents(clientId)
        return remoteEvents.map { remoteEvent ->
            eventRemoteToDataMapper.map(remoteEvent)
        }
    }
    override suspend fun getEventsWithPerformers(clientId: String): List<EventWithPerformerDataModel> {
        val remoteEventsWithPerformers = eventRemoteDataSource.getEventsWithPerformers(clientId)

        return remoteEventsWithPerformers.map { remoteEventWithPerformers ->
            val eventData= eventRemoteToDataMapper.map(remoteEventWithPerformers)
            val performersData = remoteEventWithPerformers.performers.map {
                eventPerformerRemoteToDataMapper.map(it)
            }
            Log.e("",performersData.toString())
            EventWithPerformerDataModel(eventData, performersData)
        }
    }
    override suspend fun getEventDetails(eventId: Long, clientId: String): EventDataModel {
        val remoteEventDetails = eventRemoteDataSource.getEventDetails(clientId,eventId)
        return eventRemoteToDataMapper.map(remoteEventDetails)

    }
}