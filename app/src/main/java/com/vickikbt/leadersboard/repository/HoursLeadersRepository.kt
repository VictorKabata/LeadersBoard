package com.vickikbt.leadersboard.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.vickikbt.leadersboard.data.database.AppDatabase
import com.vickikbt.leadersboard.data.network.ApiService
import com.vickikbt.leadersboard.data.network.SafeApiRequest
import com.vickikbt.leadersboard.model.HoursLeaderModel
import com.vickikbt.leadersboard.util.Coroutines
import javax.inject.Inject

class HoursLeadersRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) : SafeApiRequest() {

    private val hoursLeaders = MutableLiveData<HoursLeaderModel>()
    //private val skillLeaders = MutableLiveData<SkillLeadersModel>()

    init {
        hoursLeaders.observeForever {
            saveHoursLeaders(it)
        }
    }


    //TODO: Fix this issue-IsFetchNeeded.
    private suspend fun isFetchNeeded(): Boolean {
        return if (appDatabase.hoursLeaderDao().getHoursLeaders().isEmpty()) {
            Log.e("VickiKbt", "isFetchNeeded: True")
            true
        } else {
            Log.e("VickiKbt", "isFetchNeeded: False")
            false
        }
    }

    suspend fun fetchHoursLeaders() {
        if (isFetchNeeded()) {
            val fetchedHoursLeaders = safeApiRequest { apiService.fetchHoursLeaders() }
            hoursLeaders.postValue(fetchedHoursLeaders)
        }
    }

    private fun saveHoursLeaders(hoursLeaders: HoursLeaderModel) {
        Coroutines.io {
            appDatabase.hoursLeaderDao().saveHoursLeaders(hoursLeaders)
        }
    }

    suspend fun getHoursLeader() = appDatabase.hoursLeaderDao().getHoursLeaders()

}