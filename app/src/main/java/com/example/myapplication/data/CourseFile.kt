package com.example.myapplication.data

data class CourseFile(
    override var title: String,
    override var description: String,
    override var url: String,
    override var thumbnailUrl: String,
    var instructorUserName: String = "",
    var courseName: String? = null
) : File(title, description, url, thumbnailUrl)