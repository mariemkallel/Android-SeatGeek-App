package com.example.eventappgroovy.event.data.mapper

import com.example.eventappgroovy.event.data.datasource.remote.model.VenueRemoteModel
import com.example.eventappgroovy.event.data.model.VenueDataModel


class VenueRemoteToDataMapper {

    fun map(input: VenueRemoteModel): VenueDataModel {
        return VenueDataModel(
            name = input.name,
            address = input.address,
            state = input.state,
        )
    }
}