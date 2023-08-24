package com.example.eventappgroovy.performer.data.mapper

import com.example.eventappgroovy.event.data.datasource.remote.model.EventRemoteModel
import com.example.eventappgroovy.event.data.datasource.remote.model.PerformerRemoteModel
import com.example.eventappgroovy.event.data.model.EventDataModel
import com.example.eventappgroovy.performer.data.model.PerformerDataModel


class PerformerRemoteToDataMapper {
    fun map(input: PerformerRemoteModel): PerformerDataModel {
        return PerformerDataModel(
            name = input.name,
            )
    }
}