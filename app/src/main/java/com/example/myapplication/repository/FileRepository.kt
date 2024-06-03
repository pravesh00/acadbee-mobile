package com.example.myapplication.repository

import com.example.myapplication.data.CourseFile
import com.example.myapplication.data.File

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
    fun getFiles(): List<File> {
        val list = ArrayList<File>()
        list.add(CourseFile("RD Sharma", "This is description", "", ""))
        list.add(CourseFile("RD Sharma", "This is description", "", ""))
        list.add(CourseFile("RD Sharma", "This is description", "", ""))
        list.add(CourseFile("RD Sharma", "This is description", "", ""))
        list.add(CourseFile("RD Sharma", "This is description", "", ""))
        list.add(CourseFile("RD Sharma", "This is description", "", ""))
        list.add(CourseFile("RD Sharma", "This is description", "", ""))

        return list
    }
}