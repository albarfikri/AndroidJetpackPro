package com.albar.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.albar.academy.data.CourseEntity
import com.albar.academy.data.source.AcademyRepository

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    // with dummy
    //fun getCourses():List<CourseEntity> = DataDummy.generateDummyCourses()

    // with json
    fun getCourses(): LiveData<List<CourseEntity>> = academyRepository.getAllCourses()
}