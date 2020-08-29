package com.vickikbt.leadersboard.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.vickikbt.leadersboard.repository.HoursLeadersRepository
import kotlinx.coroutines.launch

class HoursLeadersViewModel @ViewModelInject constructor(private val hoursLeadersRepository: HoursLeadersRepository) :
    ViewModel() {

    init {
        fetchHoursLeaders()
    }

    private fun fetchHoursLeaders() {
        viewModelScope.launch {
            hoursLeadersRepository.fetchHoursLeaders()
        }
    }

    fun getHoursLeader() = liveData {
        val hoursLeaders = hoursLeadersRepository.getHoursLeader()
        emit(hoursLeaders)
    }

}