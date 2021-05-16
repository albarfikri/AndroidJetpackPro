package com.albar.academy.di

import android.content.Context
import com.albar.academy.data.source.AcademyRepository
import com.albar.academy.data.source.local.LocalDataSource
import com.albar.academy.data.source.local.room.AcademyDatabase
import com.albar.academy.data.source.remote.RemoteDataSource
import com.albar.academy.utils.AppExecutors
import com.albar.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}