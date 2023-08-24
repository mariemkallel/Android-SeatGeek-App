package com.example.eventappgroovy.event.data.mapper

import com.example.eventappgroovy.event.data.datasource.remote.model.PerformerRemoteModel
import com.example.eventappgroovy.event.data.model.PerformerDataModel
import javax.inject.Inject


class EventPerformerRemoteToDataMapper @Inject constructor()  {

    fun map(input: PerformerRemoteModel): PerformerDataModel {
        return PerformerDataModel(
            name=input.name,
        )
    }
}
