package com.vickikbt.leadersboard.model


import com.google.gson.annotations.SerializedName

data class HoursLeaderModelItem(
    val badgeUrl: String,
    val country: String,
    val hours: Int,
    val name: String
)