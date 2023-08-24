package com.example.eventappgroovy.di

import com.example.eventappgroovy.event.data.EventRepository
import com.example.eventappgroovy.event.domain.mapper.EventDataToDomainMapper
import com.example.eventappgroovy.event.domain.mapper.EventWithPerformerDataToDomainMapper
import com.example.eventappgroovy.event.domain.usecase.GetEventsUseCase
import com.example.eventappgroovy.performer.domain.mapper.PerformerDataToDomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun providesEventListUseCase(
        eventRepository: EventRepository,
        eventWithPerformerDataToDomainMapper: EventWithPerformerDataToDomainMapper
    ): GetEventsUseCase = GetEventsUseCase(eventRepository, eventWithPerformerDataToDomainMapper)

    @Provides
    @Singleton
    fun provideEventWithPerformerDataToDomainMapper(
        performerMapper: PerformerDataToDomainMapper,
        eventMapper: EventDataToDomainMapper
    ): EventWithPerformerDataToDomainMapper =
        EventWithPerformerDataToDomainMapper(performerMapper, eventMapper)

    @Provides
    @Singleton
    fun providePerformerDataToDomainMapper(): PerformerDataToDomainMapper =
        PerformerDataToDomainMapper()


    @Provides
    @Singleton
    fun provideEventDataToDomainMapper(): EventDataToDomainMapper = EventDataToDomainMapper()

}