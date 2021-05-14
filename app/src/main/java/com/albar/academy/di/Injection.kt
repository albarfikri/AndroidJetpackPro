package com.albar.academy.di

import android.content.Context
import com.albar.academy.data.source.AcademyRepository
import com.albar.academy.data.source.remote.RemoteDataSource
import com.albar.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return AcademyRepository.getInstance(remoteDataSource)
    }
}