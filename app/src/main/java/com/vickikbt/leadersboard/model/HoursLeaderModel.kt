package com.vickikbt.leadersboard.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "hours_leaders_table")
data class HoursLeaderModel(
    val badgeUrl: String,
    val country: String,
    val hours: Int,
    val name: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int
)