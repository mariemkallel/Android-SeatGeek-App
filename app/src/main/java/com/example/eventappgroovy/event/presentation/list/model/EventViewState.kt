package com.example.eventappgroovy.event.presentation.list.model

sealed class EventViewState {
    object Loading : EventViewState()
    data class Success(val events: List<EventWithPerformerPresentationModel>) : EventViewState()
    data class Error(val error: Throwable) : EventViewState()
}