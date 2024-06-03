package com.example.myapplication.data

/**
    This is data class for Student user and
    should be used to store all type of student
    related information.
    This will also serve as base for Database model
    for Student Table.

    @author : Pravesh Choudhary
 */
data class Student (
    val userName: String,
    val password: String,
    val gender: Gender,
    val profileImageUrl: String,
    val instituteName: String,
    val yearStart: Int,
    val yearEnd: Int
) : User(userName, password, gender = Gender.NOT_SPECIFIED, profileImageUrl) {
    override fun displayUserType(): String {
        return "STUDENT"
    }
}
