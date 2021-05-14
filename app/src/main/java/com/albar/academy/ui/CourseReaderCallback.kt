package com.albar.academy.ui

// used for  moving from one to another page
interface CourseReaderCallback {
    fun moveTo(position: Int, moduleId: String)
}