package com.albar.academy.data.source

import androidx.lifecycle.LiveData
import com.albar.academy.data.CourseEntity
import com.albar.academy.data.ModuleEntity

// interface for combining the repository
interface AcademyDataSource {

    fun getAllCourses(): LiveData<List<CourseEntity>>

    fun getBookmarkedCourses(): LiveData<List<CourseEntity>>

    fun getCourseWithModules(courseId: String): LiveData<CourseEntity>

    fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>>

    fun getContent(courseId: String, moduleId: String): LiveData<ModuleEntity>
}