package com.example.eventappgroovy.event.domain.mapper

import com.example.eventappgroovy.common.model.DateTimeUtils
import com.example.eventappgroovy.event.data.model.EventWithPerformerDataModel
import com.example.eventappgroovy.event.domain.model.EventDomainModel
import com.example.eventappgroovy.event.domain.model.EventDomainModelWithFormattedDate
import com.example.eventappgroovy.event.domain.model.EventWithPerformersDateFormattedDomainModel
import com.example.eventappgroovy.event.domain.model.EventWithPerformersDomainModel
import com.example.eventappgroovy.performer.domain.mapper.PerformerDataToDomainMapper
import javax.inject.Inject

class EventWithPerformerDataToDomainMapper @Inject constructor(
    private val performerMapper: PerformerDataToDomainMapper,
    private val eventMapper: EventDataToDomainMapper
) {
    fun map(input: EventWithPerformerDataModel): EventWithPerformersDomainModel {
        val eventDomain = eventMapper.map(input.event)
        val performersDomain = input.performers.map { performerMapper.map(it) }

        return EventWithPerformersDomainModel(
            event = eventDomain,
            performers = performersDomain
        )
    }
//    fun mapWithFormattedDate(input: EventWithPerformerDataModel): EventDomainModelWithFormattedDate {
//        val eventDomain = eventMapper.map(input.event)
//        val performersDomain = input.performers.map { performerMapper.map(it) }
//
//        val formattedDateTime = DateTimeUtils.formatDateTime(
//            eventDomain.datetimeLocal,
//            DateTimeUtils.FORMAT_FULL
//        )
//
//        return EventDomainModelWithFormattedDate(
//            event = eventDomain,
//            formattedDateTime = formattedDateTime,
//            performers = performersDomain
//
//        )
//    }
fun mapWithFormattedDate(input: EventWithPerformerDataModel): EventWithPerformersDateFormattedDomainModel {
    val eventDomain = eventMapper.map(input.event)
    val performersDomain = input.performers.map { performerMapper.map(it) }

    val formattedDateTime = DateTimeUtils.formatDateTime(
        eventDomain.datetimeLocal,
        DateTimeUtils.FORMAT_FULL
    )

     val eventDomainModelWithFormattedDate=EventDomainModelWithFormattedDate(
        event = eventDomain,
        formattedDateTime = formattedDateTime,

    )
    return EventWithPerformersDateFormattedDomainModel(
        event = eventDomainModelWithFormattedDate,
        performers = performersDomain

    )
}


}



