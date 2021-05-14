package com.albar.academy.data.source.remote

import android.os.Handler
import android.os.Looper
import com.albar.academy.data.source.remote.response.ContentResponse
import com.albar.academy.data.source.remote.response.CourseResponse
import com.albar.academy.data.source.remote.response.ModuleResponse
import com.albar.academy.utils.EspressoIdlingResources
import com.albar.academy.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllCourses(callback: LoadCoursesCallback) {
        EspressoIdlingResources.increment()
        handler.postDelayed(
            {
                callback.onAllCoursesReceived(jsonHelper.loadCourses())
                EspressoIdlingResources.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getModules(courseId: String, callback: LoadModulesCallback) {
        EspressoIdlingResources.increment()
        handler.postDelayed(
            {
                callback.onAllModulesReceived(jsonHelper.loadModule(courseId))
                EspressoIdlingResources.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getContent(moduleId: String, callback: LoadContentCallback) {
        EspressoIdlingResources.increment()
        handler.postDelayed(
            {
                callback.onContentReceived(jsonHelper.loadContent(moduleId))
                EspressoIdlingResources.decrement()
            },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    interface LoadCoursesCallback {
        fun onAllCoursesReceived(courseResponses: List<CourseResponse>)
    }

    interface LoadModulesCallback {
        fun onAllModulesReceived(moduleResponses: List<ModuleResponse>)
    }

    interface LoadContentCallback {
        fun onContentReceived(contentResponse: ContentResponse)
    }
}