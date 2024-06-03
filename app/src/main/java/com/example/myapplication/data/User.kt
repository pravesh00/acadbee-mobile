package com.example.myapplication.data

/**
    This is base class for all types of user in the application,
    this serves as abstract data model to be implemented
    by each user type

    @author : Pravesh Choudhary
 */

abstract class User(
    userName: String,
    password: String,
    gender: Gender,
    profileImageUrl: String
) {
    abstract fun displayUserType(): String
}
