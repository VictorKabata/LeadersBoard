package com.vickikbt.leadersboard.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickikbt.leadersboard.model.HoursLeaderModel
import com.vickikbt.leadersboard.model.HoursLeaderModelItem

@Dao
interface HoursLeaderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHoursLeaders(hoursLeaders: HoursLeaderModel)

    @Query("SELECT * FROM hours_leaders_table")
    suspend fun getHoursLeaders(): List<HoursLeaderModelItem>
}