package com.example.eventappgroovy.event.domain.mapper

import com.example.eventappgroovy.event.data.model.EventDataModel
import com.example.eventappgroovy.event.domain.model.EventDomainModel
import javax.inject.Inject

class EventDataToDomainMapper @Inject constructor() {
    fun map(input: EventDataModel):EventDomainModel {
        return EventDomainModel(
            id=input.id,
            type = input.type,
            datetimeLocal = input.datetime_local,
            shortTitle = input.short_title,
           // image_attribution =input.image_attribution

        )
    }
}

