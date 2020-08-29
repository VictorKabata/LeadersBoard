package com.vickikbt.leadersboard.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vickikbt.leadersboard.data.database.dao.HoursLeaderDao
import com.vickikbt.leadersboard.data.database.dao.SkillLeaderDao
import com.vickikbt.leadersboard.model.HoursLeaderModelItem
import com.vickikbt.leadersboard.model.SkillLeadersModelItem

@Database(entities = [HoursLeaderModelItem::class, SkillLeadersModelItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun hoursLeaderDao(): HoursLeaderDao

    abstract fun skillLeaderDao(): SkillLeaderDao
}