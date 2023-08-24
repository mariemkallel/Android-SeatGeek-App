package com.example.eventappgroovy.event.domain.mapper

import com.example.eventappgroovy.event.data.model.VenueDataModel
import com.example.eventappgroovy.event.domain.model.VenueDomainModel

class VenueDataToDomainMapper {
    fun map(input: VenueDataModel): VenueDomainModel {
        return VenueDomainModel(
            name = input.name,
            address = input.address,
            state = input.state,
        )
    }
}

