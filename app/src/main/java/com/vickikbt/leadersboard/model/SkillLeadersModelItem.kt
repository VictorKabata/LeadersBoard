package com.vickikbt.leadersboard.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skill_leaders_table")
data class SkillLeadersModelItem(
    val badgeUrl: String,
    val country: String,
    val name: String,
    val score: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int
)