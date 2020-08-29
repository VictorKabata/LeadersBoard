package com.vickikbt.leadersboard.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vickikbt.leadersboard.repository.AppRepository

class AppViewModel @ViewModelInject constructor(private val appRepository: AppRepository) :
    ViewModel() {

    fun fetchHoursLeaders() = liveData {
        val hoursLeaders = appRepository.fetchHoursLeaders()
        emit(hoursLeaders)
    }

    fun fetchSkillLeaders() = liveData {
        val skillLeaders = appRepository.fetchSkillLeaders()
        emit(skillLeaders)
    }


}