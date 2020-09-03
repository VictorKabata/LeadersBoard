package com.vickikbt.leadersboard.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vickikbt.leadersboard.data.database.AppDatabase
import com.vickikbt.leadersboard.data.network.ApiService
import com.vickikbt.leadersboard.data.network.SafeApiRequest
import com.vickikbt.leadersboard.model.HoursLeaderModel
import com.vickikbt.leadersboard.model.SkillLeadersModel
import com.vickikbt.leadersboard.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) : SafeApiRequest() {

    private val hoursLeaders = MutableLiveData<List<HoursLeaderModel>>()
    private val skillLeaders = MutableLiveData<List<SkillLeadersModel>>()

    init {
        hoursLeaders.observeForever {
            saveHoursLeaders(it)
        }

        skillLeaders.observeForever {
            saveSkillLeaders(it)
        }
    }


    //TODO: Fix this issue-IsFetchNeeded.
    //Check if fetch is needed.
    private fun isFetchNeeded(): Boolean {
        return true
    }

    //TODO: Catch no internet exception
    //Fetch data from the API if fetch is needed is true
    private suspend fun fetchHoursLeaders() {
        if (isFetchNeeded()) {
            val fetchedHoursLeaders = safeApiRequest { apiService.fetchHoursLeaders() }
            hoursLeaders.postValue(fetchedHoursLeaders)
        }
    }

    private suspend fun fetchSkillLeaders() {
        if (isFetchNeeded()) {
            val fetchedSkillLeaders = safeApiRequest { apiService.fetchSkillLeaders() }
            skillLeaders.postValue(fetchedSkillLeaders)
        }
    }

    //Save the fetched data from the API to SQLite DB.
    private fun saveHoursLeaders(hoursLeaders: List<HoursLeaderModel>) {
        Coroutines.io {
            appDatabase.hoursLeaderDao().saveHoursLeaders(hoursLeaders)
        }
    }

    private fun saveSkillLeaders(skillLeaders: List<SkillLeadersModel>) {
        Coroutines.io {
            appDatabase.skillLeaderDao().saveSkillLeaders(skillLeaders)
        }
    }

    //It fetches data from the API if fetch is needed.
    //then gets data from the SQLite DB to display to the UI.
    suspend fun getHoursLeader(): LiveData<List<HoursLeaderModel>> {
        return withContext(Dispatchers.IO) {
            fetchHoursLeaders()
            appDatabase.hoursLeaderDao().getHoursLeaders()
        }
    }

    suspend fun getSkillLeader(): LiveData<List<SkillLeadersModel>> {
        return withContext(Dispatchers.IO) {
            fetchSkillLeaders()
            appDatabase.skillLeaderDao().getSkillLeaders()
        }
    }

}