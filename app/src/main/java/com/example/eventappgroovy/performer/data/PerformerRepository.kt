package com.example.eventappgroovy.performer.data

import com.example.eventappgroovy.performer.data.model.PerformerDataModel


interface PerformerRepository {
    suspend fun getPerformersFromEvents(clientId:String,eventId: Long): List<PerformerDataModel>
}

