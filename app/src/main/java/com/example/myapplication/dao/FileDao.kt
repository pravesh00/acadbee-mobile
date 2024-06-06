package com.example.myapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.CourseFile

@Dao
interface FileDao {
    @Insert
     suspend fun insertAllCourseFiles(vararg files: CourseFile)

    @Query("SELECT * FROM coursefile")
     suspend fun getAll(): List<CourseFile>
}