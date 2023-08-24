package com.example.eventappgroovy.performer.presentation.mapper

import com.example.eventappgroovy.performer.data.model.PerformerDataModel
import com.example.eventappgroovy.performer.domain.model.PerformerDomainModel
import com.example.eventappgroovy.performer.presentation.model.PerformerPresentationModel


object PerformerDomainToPresentationMapper {
    fun map(input: PerformerDomainModel): PerformerPresentationModel {
        return PerformerPresentationModel(
            name= input.name,

        )
    }
}
