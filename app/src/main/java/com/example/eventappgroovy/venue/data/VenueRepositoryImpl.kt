package com.example.eventapp.event.data

import com.example.eventappgroovy.event.data.VenueRepository
import com.example.eventappgroovy.event.data.datasource.remote.VenueRemoteDataSource
import com.example.eventappgroovy.event.data.mapper.VenueRemoteToDataMapper
import com.example.eventappgroovy.event.data.model.EventDataModel
import com.example.eventappgroovy.event.data.model.VenueDataModel
import javax.inject.Inject

class VenueRepositoryImpl @Inject constructor(
    private val venueRemoteDataSource: VenueRemoteDataSource,
    private val eventRemoteToDataMapper: VenueRemoteToDataMapper
) : VenueRepository {

//    override suspend fun getVenue (eventId: String,clientId: String) :VenueDataModel {
//        val  venue= venueRemoteDataSource.getVenue(eventId)
//        return eventRemoteToDataMapper.map(venue)
//
//    }
}