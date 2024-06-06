package com.example.myapplication.repository

import android.content.Context
import android.util.Log
import com.example.myapplication.data.CourseFile
import com.example.myapplication.data.File
import com.example.myapplication.database.AppDatabase

class FileRepository {
    /**
    This is Companion object used to make static members of a
    Kotlin Class.
    We have made this class singleton as we don't want multiple concurrent
    types of Database calls to User Table
    @TODO: Might add locks to this class later to deal concurrency of methods
    @author : Pravesh Choudhary
     */
    companion object {
        private var INSTANCE: FileRepository? = null


        fun getInstance(): FileRepository {
            if (INSTANCE == null) {
                INSTANCE = FileRepository()
            }
            return INSTANCE!!
        }


    }

    /**
        @Method: Get Files
        @param: None
        @return: List of files available in database
        @TODO: Implementation Pending
        @author : Pravesh Choudhary
     */
    suspend fun getFiles(context: Context): List<File> {
        val list = AppDatabase.invoke(context).fileDao().getAll()
        Log.d("get", list.size.toString())
        return list
    }

    suspend fun addDummyData(appDatabase: AppDatabase) {
        Log.d("hell", "p")
        Log.d("hell", "p")
        appDatabase.fileDao().insertAllCourseFiles(CourseFile(0,"RD Sharma", "This is description", "hell", "https://5.imimg.com/data5/SELLER/Default/2022/11/KW/DU/MV/106144956/maths-1.jpg", "a"))
        Log.d("hell","p")
    }
}