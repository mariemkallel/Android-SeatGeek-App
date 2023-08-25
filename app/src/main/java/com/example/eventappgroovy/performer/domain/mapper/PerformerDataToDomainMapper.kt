package com.example.eventappgroovy.performer.domain.mapper

import com.example.eventappgroovy.event.data.model.PerformerDataModel
import com.example.eventappgroovy.performer.domain.model.PerformerDomainModel

class PerformerDataToDomainMapper {
    fun map(input: PerformerDataModel): PerformerDomainModel {
        return PerformerDomainModel(
            name = input.name
        )
    }
}

