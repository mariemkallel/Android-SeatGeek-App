package com.example.eventappgroovy.event.presentation.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventapp.event.presentation.list.mapper.EventDomainToPresentationMapper
import com.example.eventappgroovy.event.domain.usecase.GetEventsUseCase
import com.example.eventappgroovy.event.presentation.list.mapper.EventWithPerformersToPresentationMapper
import com.example.eventappgroovy.event.presentation.list.model.EventPresentationModel
import com.example.eventappgroovy.event.presentation.list.model.EventViewState
import com.example.eventappgroovy.event.presentation.list.model.EventWithPerformerPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventListViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {
    init {
        Log.d("ViewModelDebug", "EventListViewModel initialized")
    }
    private val _viewState = MutableLiveData<EventViewState>()
    val viewState: LiveData<EventViewState> = _viewState

    fun loadEvents(clientId: String) {
        Log.e("MyFragment", "kbal usecase")
        viewModelScope.launch {
            _viewState.value = EventViewState.Loading
            try {
                val events = getEventsUseCase.invoke(clientId)
                Log.e("EventListViewModel",events.toString())
                val eventPresentationModels = events.map { eventDomain ->
                    EventWithPerformersToPresentationMapper.map(eventDomain)
                }

                _viewState.value = EventViewState.Success(eventPresentationModels)
            } catch (e: Exception) {
                Log.e("EventListViewModel", "Error fetching events: ${e.message}")
                _viewState.value = EventViewState.Error(e)
            }
        }
    }
}

