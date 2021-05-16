package com.albar.academy.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.albar.academy.data.source.local.entity.CourseEntity
import com.albar.academy.data.source.AcademyRepository

class BookmarkViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    // with dummy
    //fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()

    // with json
    fun getBookmarks(): LiveData<List<CourseEntity>> = academyRepository.getBookmarkedCourses()
}