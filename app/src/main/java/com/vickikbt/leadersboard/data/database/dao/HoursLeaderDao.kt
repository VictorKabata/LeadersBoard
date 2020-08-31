package com.vickikbt.leadersboard.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vickikbt.leadersboard.model.HoursLeaderModel

@Dao
interface HoursLeaderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHoursLeaders(hoursLeaders: List<HoursLeaderModel>)

    @Query("SELECT * FROM hours_leaders_table")
    fun getHoursLeaders(): LiveData<List<HoursLeaderModel>>
}