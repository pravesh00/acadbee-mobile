package com.example.myapplication.data

/**
    This is data class for Instructor user and
    should be used to store all type of Instructor
    related information.
    This will also serve as base for Database model
    for Instructor Table.

    @author : Pravesh Choudhary
 */
data class Instructor(
    val userName: String,
    val password: String,
    val gender: Gender,
    val profileImageUrl: String,
    val currentInstituteName: String
): User(userName, password, gender = Gender.NOT_SPECIFIED, profileImageUrl) {
    override fun displayUserType(): String {
        return "INSTRUCTOR"
    }
}
