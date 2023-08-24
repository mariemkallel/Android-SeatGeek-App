package com.example.eventappgroovy.event.data.datasource.remote

import android.util.Log
import com.example.eventappgroovy.common.model.Resources
import com.example.eventappgroovy.event.data.datasource.remote.model.EventListResponse
import com.example.eventappgroovy.event.data.datasource.remote.model.EventRemoteModel
import com.example.eventappgroovy.event.data.datasource.remote.model.MetaData
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class EventRemoteDataSource @Inject constructor(private val eventApiService: EventApiService) {

//    suspend fun getEvents(clientId: String): List<EventRemoteModel> {
//        return eventApiService.getEvents(clientId)
//    }

    suspend fun getEvents(clientId: String): List<EventRemoteModel> {
        return withContext(Dispatchers.IO) {
            try {
                Log.e("EventApp", "Fetching events with clientId: $clientId")

                val response = eventApiService.getEvents(clientId)
                if (response.isSuccessful) {
                    val eventListResponse = response.body()
                    if (eventListResponse != null) {
                        Log.e("EventApp", "Response JSON: ${Gson().toJson(eventListResponse)}")

                        val events = eventListResponse.events
                        Log.e("EventApp", "Fetched ${events.size} events successfully")
                        events
                    } else {
                        Log.e("EventApp", "Response body is null")
                        emptyList()
                    }
                } else {
                    Log.e("EventApp", "Error response: ${response.code()}")
                    emptyList()
                }
            } catch (e: Throwable) {
                Log.e("EventApp", "Exception: ${e.message}")
                emptyList()
            }
        }
    }

    suspend fun getEventsWithPerformers(clientId: String): List<EventRemoteModel> {
        return withContext(Dispatchers.IO) {
            try {
                Log.e("EventApp", "Fetching events with clientId: $clientId")

                val response = eventApiService.getEvents(clientId)
                if (response.isSuccessful) {
                    val eventListResponse = response.body()
                    if (eventListResponse != null) {
                        Log.e("EventApp", "Response JSON: ${Gson().toJson(eventListResponse)}")

                        val events = eventListResponse.events
                        Log.e("EventApp", "Fetched ${events.size} events successfully")
                        events
                    } else {
                        Log.e("EventApp", "Response body is null")
                        emptyList()
                    }
                } else {
                    Log.e("EventApp", "Error response: ${response.code()}")
                    emptyList()
                }
            } catch (e: Throwable) {
                Log.e("EventApp", "Exception: ${e.message}")
                emptyList()
            }
        }
    }

    suspend fun getEventDetails(clientId: String, eventId: Long): EventRemoteModel {
    try {
        val response = eventApiService.getEventDetails(eventId,clientId)
        if (response.isSuccessful) {
            return response.body() ?: throw EventDetailsNotFoundException()
        }
    } catch (e: Exception) {
        throw e
    }
    throw EventDetailsNotFoundException()
}


}
class EventDetailsNotFoundException : Exception("Event details not found")
