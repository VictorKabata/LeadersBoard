package com.vickikbt.leadersboard.model


import com.google.gson.annotations.SerializedName

data class SkillLeadersModelItem(
    val badgeUrl: String,
    val country: String,
    val name: String,
    val score: Int
)