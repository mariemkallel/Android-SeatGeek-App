package com.example.eventappgroovy.event.data.datasource.remote

import com.example.eventappgroovy.event.data.datasource.remote.model.EventListResponse
import com.example.eventappgroovy.event.data.datasource.remote.model.EventRemoteModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Response

interface EventApiService {
    @GET("events")
    suspend fun getEvents(@Query("client_id") clientId: String): Response<EventListResponse>
    @GET("events/{id}")
    suspend fun getEventDetails(
        @Path("id") eventId: Long,
        @Query("client_id") clientId: String
    ): Response<EventRemoteModel>
}