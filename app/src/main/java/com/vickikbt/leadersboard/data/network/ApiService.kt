package com.vickikbt.leadersboard.data.network

import com.vickikbt.leadersboard.model.HoursLeaderModelItem
import com.vickikbt.leadersboard.model.SkillLeadersModelItem
import com.vickikbt.leadersboard.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.HOURS_ENDPOINT)
    suspend fun fetchHoursLeaders(): Response<List<HoursLeaderModelItem>>

    @GET(Constants.HOURS_ENDPOINT)
    suspend fun fetchSkillLeaders(): Response<List<SkillLeadersModelItem>>
}