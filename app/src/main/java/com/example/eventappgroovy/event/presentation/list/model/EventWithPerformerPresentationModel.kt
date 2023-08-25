package com.example.eventappgroovy.event.presentation.list.model

import com.example.eventappgroovy.performer.domain.model.PerformerDomainModel
import com.example.eventappgroovy.performer.presentation.model.PerformerPresentationModel

data class EventWithPerformerPresentationModel(
    val id:Long,
    val type: String,
    val datetimeLocal: String,
    val shortTitle: String,
    val formattedDate : String,
    val performers: List<PerformerDomainModel>,

)