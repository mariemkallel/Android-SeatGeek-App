package com.example.eventappgroovy.di

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Debug
import android.util.Log
import com.example.eventappgroovy.event.data.EventRepository
import com.example.eventappgroovy.event.data.EventRepositoryImpl
import com.example.eventappgroovy.event.data.datasource.remote.EventApiService
import com.example.eventappgroovy.event.data.datasource.remote.EventRemoteDataSource
import com.example.eventappgroovy.event.data.datasource.remote.PerformerRemoteDataSource
import com.example.eventappgroovy.event.data.mapper.EventPerformerRemoteToDataMapper
import com.example.eventappgroovy.event.data.mapper.EventRemoteToDataMapper
import com.example.eventappgroovy.event.domain.mapper.EventDataToDomainMapper
import com.example.eventappgroovy.performer.data.PerformerRepository
import com.example.eventappgroovy.performer.data.PerformerRepositoryImpl
import com.example.eventappgroovy.performer.data.mapper.PerformerRemoteToDataMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton





@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providesEventDataSource(eventApiService: EventApiService) =
        EventRemoteDataSource(eventApiService)

    @Provides
    @Singleton
    fun providesEventRepository(
        eventRemoteDataSource: EventRemoteDataSource,
        eventRemoteToDataMapper: EventRemoteToDataMapper,
        eventPerformerRemoteToDataMapper: EventPerformerRemoteToDataMapper,
        ): EventRepository {
        return EventRepositoryImpl(eventRemoteDataSource,eventRemoteToDataMapper,eventPerformerRemoteToDataMapper)
    }
    @Provides
    fun provideEventRemoteToDataMapper(): EventRemoteToDataMapper {
        return EventRemoteToDataMapper()
    }
    @Provides
    @Singleton
    fun providesPerformerRepository(
        eventRemoteDataSource: EventRemoteDataSource,
        performerRemoteToDataMapper: PerformerRemoteToDataMapper
    ): PerformerRepository {
        return PerformerRepositoryImpl(eventRemoteDataSource,performerRemoteToDataMapper)
    }

}