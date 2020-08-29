package com.vickikbt.leadersboard.di

import com.vickikbt.leadersboard.data.database.AppDatabase
import com.vickikbt.leadersboard.data.network.ApiService
import com.vickikbt.leadersboard.repository.HoursLeadersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)

@Module
object RepositoryModule {

    @Provides
    fun providesAppRepository(
        apiService: ApiService,
        appDatabase: AppDatabase
    ): HoursLeadersRepository {
        return HoursLeadersRepository(apiService, appDatabase)
    }
}