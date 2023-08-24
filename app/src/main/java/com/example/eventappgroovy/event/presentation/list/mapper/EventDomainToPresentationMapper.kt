package com.example.eventapp.event.presentation.list.mapper

import com.example.eventappgroovy.event.data.model.EventDataModel
import com.example.eventappgroovy.event.domain.model.EventDomainModel
import com.example.eventappgroovy.event.presentation.list.model.EventPresentationModel
import com.example.eventappgroovy.performer.data.model.PerformerDataModel


object EventDomainToPresentationMapper {
    fun map(input: EventDomainModel): EventPresentationModel {
        return EventPresentationModel(
            id=input.id,
            type = input.type,
            datetimeLocal = input.datetimeLocal,
            shortTitle = input.shortTitle
        )
    }
}
