package com.example.myapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coursefile")
data class CourseFile(
    @PrimaryKey(autoGenerate = true)override var id: Int = 0,
    @ColumnInfo(name = "title") override var title: String,
    @ColumnInfo(name = "description") override var description: String,
    @ColumnInfo(name = "url") override var url: String,
    @ColumnInfo(name = "thumbnailUrl") override var thumbnailUrl: String,
    @ColumnInfo(name = "instructorUserName") var instructorUserName: String = "",
    @ColumnInfo(name = "courseName") var courseName: String? = null
) : File(id, title, description, url, thumbnailUrl)