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
    override val userName: String,
    override val password: String,
    override val gender: Gender = Gender.NOT_SPECIFIED,
    override val profileImageUrl: String = "",
    val instituteName: String = "",
    val yearStart: Int = 1999,
    val yearEnd: Int = 1999
) : User(userName, password, gender = Gender.NOT_SPECIFIED, profileImageUrl) {
    override fun displayUserType(): String {
        return "STUDENT"
    }
}
