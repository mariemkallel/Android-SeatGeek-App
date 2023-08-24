package com.example.eventappgroovy.performer.domain.usecase


import com.example.eventappgroovy.performer.data.PerformerRepository
import com.example.eventappgroovy.performer.domain.mapper.PerformerDataToDomainMapper
import com.example.eventappgroovy.performer.domain.model.PerformerDomainModel
import javax.inject.Inject

class GetPerformersUsecase @Inject constructor(
    private val performerRepository: PerformerRepository,
    private val performerDataToDomainMapper: PerformerDataToDomainMapper
) {

    suspend operator fun invoke(clientId: String, eventId: Long): List<PerformerDomainModel> {
//        val performersDataList = performerRepository.getPerformersFromEvents(clientId, eventId)
//        return performersDataList.map { performerData ->
//            performerDataToDomainMapper.map(performerData)
//        }

        return emptyList()
    }
}