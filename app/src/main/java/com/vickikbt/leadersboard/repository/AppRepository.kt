package com.vickikbt.leadersboard.repository

import com.vickikbt.leadersboard.data.network.ApiService
import com.vickikbt.leadersboard.data.network.SafeApiRequest
import com.vickikbt.leadersboard.model.HoursLeaderModel
import com.vickikbt.leadersboard.model.SkillLeadersModel
import javax.inject.Inject

class AppRepository @Inject constructor(private val apiService: ApiService):SafeApiRequest() {


    fun isFetchNeeded(): Boolean {
        return true
    }

    suspend fun fetchHoursLeaders(): HoursLeaderModel {
        return safeApiRequest { apiService.fetchHoursLeaders() }
    }

    suspend fun fetchSkillLeaders(): SkillLeadersModel {
        return safeApiRequest { apiService.fetchSkillLeaders() }
    }

}