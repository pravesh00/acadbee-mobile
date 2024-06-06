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
        return list
    }

    suspend fun addDummyData(appDatabase: AppDatabase) {
        appDatabase.fileDao().insertAllCourseFiles(CourseFile(0,"RD Sharma", "This is description", "ttps://m.media-amazon.com/images/I/51PqozDOOPL._SY445_SX342_.jpg", "https://5.imimg.com/data5/SELLER/Default/2022/11/KW/DU/MV/106144956/maths-1.jpg", "a"),
            CourseFile(0,"RD Sharma", "This is description", "ttps://m.media-amazon.com/images/I/51PqozDOOPL._SY445_SX342_.jpg", "https://5.imimg.com/data5/SELLER/Default/2022/11/KW/DU/MV/106144956/maths-1.jpg", "a"),
            CourseFile(0,"RD Sharma", "This is description", "ttps://m.media-amazon.com/images/I/51PqozDOOPL._SY445_SX342_.jpg", "https://5.imimg.com/data5/SELLER/Default/2022/11/KW/DU/MV/106144956/maths-1.jpg", "a"),
            CourseFile(0,"RD Sharma", "This is description", "ttps://m.media-amazon.com/images/I/51PqozDOOPL._SY445_SX342_.jpg", "https://5.imimg.com/data5/SELLER/Default/2022/11/KW/DU/MV/106144956/maths-1.jpg", "a"))
    }
}