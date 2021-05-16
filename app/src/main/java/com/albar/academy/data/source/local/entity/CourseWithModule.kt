package com.albar.academy.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

// new obyek to combine CourseEntity with ModulesEntity with @embedded and @relation
data class CourseWithModule (
    @Embedded
    var mCourse: CourseEntity,
    @Relation(parentColumn = "courseId", entityColumn = "courseId")
    var mModules: List<ModuleEntity>
)