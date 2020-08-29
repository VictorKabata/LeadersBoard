package com.vickikbt.leadersboard.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.vickikbt.leadersboard.repository.AppRepository
import kotlinx.coroutines.launch

class AppViewModel @ViewModelInject constructor(private val appRepository: AppRepository) :
    ViewModel() {

    fun fetchHoursLeaders() = liveData {
        viewModelScope.launch {
            val hoursLeaders = appRepository.fetchHoursLeaders()
            emit(hoursLeaders)
        }
    }

    fun fetchSkillLeaders() = liveData {
        viewModelScope.launch {
            val skillLeaders = appRepository.fetchSkillLeaders()
            emit(fetchHoursLeaders())
        }
    }


}