package com.example.eventappgroovy.event.data.mapper

import com.example.eventappgroovy.event.data.datasource.remote.model.EventRemoteModel
import com.example.eventappgroovy.event.data.model.EventDataModel
import javax.inject.Inject


class EventRemoteToDataMapper @Inject constructor()  {

    fun map(input: EventRemoteModel): EventDataModel {
        return EventDataModel(
            id=input.id,
            type = input.type,
            datetime_local = input.datetime_local,
            short_title = input.short_title,

        )
    }
}