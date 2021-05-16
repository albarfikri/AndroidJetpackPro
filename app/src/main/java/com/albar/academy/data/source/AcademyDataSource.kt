package com.albar.academy.data.source

import androidx.lifecycle.LiveData
import com.albar.academy.data.source.local.entity.CourseEntity
import com.albar.academy.data.source.local.entity.CourseWithModule
import com.albar.academy.data.source.local.entity.ModuleEntity
import com.albar.academy.vo.Resource

// interface for combining the repository
interface AcademyDataSource {

    //    fun getAllCourses(): LiveData<List<CourseEntity>>
    fun getAllCourses(): LiveData<Resource<List<CourseEntity>>>

    fun getCourseWithModules(courseId: String): LiveData<Resource<CourseWithModule>>

    fun getAllModulesByCourse(courseId: String): LiveData<Resource<List<ModuleEntity>>>

    fun getContent(moduleId: String): LiveData<Resource<ModuleEntity>>

    fun getBookmarkedCourses(): LiveData<List<CourseEntity>>

    // menambahkan course ke daftar bookmark
    fun setCourseBookmark(course: CourseEntity, state: Boolean)

    // digunkana untuk memperlihatkan module mana yang terkahir dibaca
    fun setReadModule(module: ModuleEntity)
}