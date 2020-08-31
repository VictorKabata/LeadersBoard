package com.vickikbt.leadersboard.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickikbt.leadersboard.model.SkillLeadersModel

@Dao
interface SkillLeaderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSkillLeaders(skillLeaders: SkillLeadersModel)

    @Query("SELECT * FROM skill_leaders_table")
    fun getSkillLeaders(): LiveData<List<SkillLeadersModel>>

}