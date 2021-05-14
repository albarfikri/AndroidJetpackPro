package com.albar.academy.ui.bookmark

import com.albar.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}