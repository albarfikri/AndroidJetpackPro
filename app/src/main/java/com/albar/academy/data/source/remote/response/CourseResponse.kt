package com.albar.academy.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Saving data from CourseResponse
@Parcelize
data class CourseResponse(
    var id: String,
    var title: String,
    var description: String,
    var date: String,
    var imagePath: String
) : Parcelable