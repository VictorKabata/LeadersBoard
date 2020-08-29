package com.vickikbt.leadersboard.data.network

import com.vickikbt.leadersboard.model.HoursLeaderModel
import com.vickikbt.leadersboard.model.SkillLeadersModel
import com.vickikbt.leadersboard.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.HOURS_ENDPOINT)
    suspend fun fetchHoursLeaders(): Response<HoursLeaderModel>

    @GET(Constants.HOURS_ENDPOINT)
    suspend fun fetchSkillLeaders(): Response<SkillLeadersModel>
}