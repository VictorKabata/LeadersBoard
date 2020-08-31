package com.vickikbt.leadersboard.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.vickikbt.leadersboard.repository.HoursLeadersRepository
import com.vickikbt.leadersboard.util.ApiException
import com.vickikbt.leadersboard.util.NoInternetException
import com.vickikbt.leadersboard.util.StateListener
import kotlinx.coroutines.launch

class HoursLeadersViewModel @ViewModelInject constructor(private val hoursLeadersRepository: HoursLeadersRepository) :
    ViewModel() {

    init {
        fetchHoursLeaders()
    }

    var stateListener: StateListener? = null

    private fun fetchHoursLeaders() {
        viewModelScope.launch {
            stateListener?.onLoading()
            try {
                hoursLeadersRepository.fetchHoursLeaders()
                stateListener?.onSuccess("Data Fetched")
                return@launch
            } catch (e: ApiException) {
                stateListener?.onFailure(e.toString())
                return@launch
            } catch (e: NoInternetException) {
                stateListener?.onFailure(e.toString())
                return@launch
            }
        }
    }

    fun getHoursLeader() = liveData {
        stateListener?.onLoading()
        try {
            val hoursLeaders = hoursLeadersRepository.getHoursLeader()
            emit(hoursLeaders)
            stateListener?.onSuccess("Data fetched from db")
            return@liveData
        } catch (e: Exception) {
            stateListener?.onFailure(e.toString())
            return@liveData
        }
    }

}