package com.vickikbt.leadersboard.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.vickikbt.leadersboard.repository.LeadersRepository
import com.vickikbt.leadersboard.util.Coroutines.lazyDeferred

class HoursLeadersViewModel @ViewModelInject constructor(private val leadersRepository: LeadersRepository) :
    ViewModel() {

    val hoursLeaders by lazyDeferred { leadersRepository.getHoursLeader() }


}