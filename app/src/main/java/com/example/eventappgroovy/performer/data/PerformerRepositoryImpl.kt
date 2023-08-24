package com.example.eventappgroovy.performer.data

import com.example.eventappgroovy.event.data.datasource.remote.EventRemoteDataSource
import com.example.eventappgroovy.event.data.datasource.remote.PerformerRemoteDataSource
import com.example.eventappgroovy.event.data.model.EventDataModel
import com.example.eventappgroovy.performer.data.mapper.PerformerRemoteToDataMapper
import com.example.eventappgroovy.performer.data.model.PerformerDataModel
import javax.inject.Inject

class PerformerRepositoryImpl @Inject constructor(
    private val eventRemoteDataSource: EventRemoteDataSource,
    private val performerRemoteToDataMapper: PerformerRemoteToDataMapper

) : PerformerRepository {

    override  suspend fun getPerformersFromEvents(clientId:String,eventId: Long): List<PerformerDataModel>{

        val remoteEventDetails = eventRemoteDataSource.getEventDetails(clientId,eventId)
        val performersRemoteList = remoteEventDetails.performers

        val performersDataList = performersRemoteList.map { remotePerformer ->
            performerRemoteToDataMapper.map(remotePerformer)
        }

        return performersDataList
    }

}