package com.vickikbt.leadersboard.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickikbt.leadersboard.model.SkillLeadersModelItem

@Dao
interface SkillLeaderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSkillLeaders(skillLeaders: SkillLeadersModelItem)

    @Query("SELECT * FROM skill_leaders_table")
    suspend fun getSkillLeaders(): List<SkillLeadersModelItem>

}