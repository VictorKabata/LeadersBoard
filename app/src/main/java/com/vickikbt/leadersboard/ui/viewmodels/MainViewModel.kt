package com.vickikbt.leadersboard.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.vickikbt.leadersboard.repository.MainRepository
import com.vickikbt.leadersboard.util.Coroutines.lazyDeferred

class MainViewModel @ViewModelInject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    val hoursLeaders by lazyDeferred { mainRepository.getHoursLeader() }

    val skillLeaders by lazyDeferred { mainRepository.getSkillLeader() }


}