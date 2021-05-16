package com.albar.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.albar.academy.data.source.local.entity.CourseEntity
import com.albar.academy.data.source.AcademyRepository
import com.albar.academy.vo.Resource

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    // with dummy
    //fun getCourses():List<CourseEntity> = DataDummy.generateDummyCourses()

    // with json
    fun getCourses(): LiveData<Resource<List<CourseEntity>>> = academyRepository.getAllCourses()
}