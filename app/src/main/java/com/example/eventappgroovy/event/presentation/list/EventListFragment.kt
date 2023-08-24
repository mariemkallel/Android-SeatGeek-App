package com.example.eventapp.event.presentation.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eventappgroovy.event.presentation.list.model.EventViewState
import com.example.eventappgroovy.databinding.FragmentEventListBinding
import com.example.eventappgroovy.event.domain.usecase.GetEventsUseCase
import com.example.eventappgroovy.event.presentation.list.EventAdapter
import com.example.eventappgroovy.event.presentation.list.EventListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventListFragment : Fragment() {
    private var _binding: FragmentEventListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EventListViewModel by viewModels()

    private lateinit var adapter: EventAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentEventListBinding.inflate(inflater, container, false)
    return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = EventAdapter()

        recyclerView = binding.eventRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.viewState.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is EventViewState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.eventRecyclerView.visibility = View.GONE
                    binding.errorTextView.visibility = View.GONE
                }
                is EventViewState.Success -> {
                    adapter.submitList(state.events)
                    binding.progressBar.visibility = View.GONE
                    binding.eventRecyclerView.visibility = View.VISIBLE
                    binding.errorTextView.visibility = View.GONE
                }
                is EventViewState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.eventRecyclerView.visibility = View.GONE
                    binding.errorTextView.visibility = View.VISIBLE
                    binding.errorTextView.text = "Error: "
                }
            }
        })

        viewModel.loadEvents("MzU3NjAxMzl8MTY5MjI4MTE2NC4zOTc4Mzc2") // Pass the clientId here

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

