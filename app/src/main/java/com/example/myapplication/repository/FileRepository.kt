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
        list.add(CourseFile("RD Sharma1", "Embark on a journey of mathematical discovery with \"Exploring Mathematics: Class 7.\" This engaging textbook is designed to make learning mathematics an enjoyable and enriching experience for students at the 7th-grade level. Authored with precision and pedagogical expertise, this book aligns with the latest curriculum standards, ensuring a seamless learning experience.", "https://www.antennahouse.com/hubfs/xsl-fo-sample/pdf/basic-link-1.pdf", "https://m.media-amazon.com/images/I/51PqozDOOPL._SY445_SX342_.jpg"))
        list.add(CourseFile("RD Sharma", "This is description", "https://www.antennahouse.com/hubfs/xsl-fo-sample/pdf/basic-link-1.pdf", "https://m.media-amazon.com/images/I/51PqozDOOPL._SY445_SX342_.jpg"))
        list.add(CourseFile("RD Sharma", "This is description", "https://www.antennahouse.com/hubfs/xsl-fo-sample/pdf/basic-link-1.pdf", "https://m.media-amazon.com/images/I/51PqozDOOPL._SY445_SX342_.jpg"))
        list.add(CourseFile("RD Sharma", "This is description", "https://www.antennahouse.com/hubfs/xsl-fo-sample/pdf/basic-link-1.pdf", "https://m.media-amazon.com/images/I/51PqozDOOPL._SY445_SX342_.jpg"))
        list.add(CourseFile("RD Sharma", "This is description", "https://www.antennahouse.com/hubfs/xsl-fo-sample/pdf/basic-link-1.pdf", "https://m.media-amazon.com/images/I/51PqozDOOPL._SY445_SX342_.jpg"))
        list.add(CourseFile("RD Sharma", "This is description", "https://www.antennahouse.com/hubfs/xsl-fo-sample/pdf/basic-link-1.pdf", "https://m.media-amazon.com/images/I/51PqozDOOPL._SY445_SX342_.jpg"))
        list.add(CourseFile("RD Sharma7", "This is description", "https://www.antennahouse.com/hubfs/xsl-fo-sample/pdf/basic-link-1.pdf", "https://m.media-amazon.com/images/I/51PqozDOOPL._SY445_SX342_.jpg"))

        return list
    }
}