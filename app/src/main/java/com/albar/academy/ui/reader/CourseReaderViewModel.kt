package com.albar.academy.ui.reader

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.albar.academy.data.ModuleEntity
import com.albar.academy.data.source.AcademyRepository

class CourseReaderViewModel(private val academyRepository: AcademyRepository) : ViewModel() {
    private lateinit var courseId: String
    private lateinit var moduleId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun setSelectedModule(moduleId: String) {
        this.moduleId = moduleId
    }

    fun getModules(): LiveData<List<ModuleEntity>> =
        academyRepository.getAllModulesByCourse(courseId)

    fun getSelectedModule(): LiveData<ModuleEntity> =
        academyRepository.getContent(courseId, moduleId)

}