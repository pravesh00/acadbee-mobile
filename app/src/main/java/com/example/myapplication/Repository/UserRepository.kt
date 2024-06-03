package com.example.myapplication.Repository

import com.example.myapplication.data.User

class UserRepository {
    /**
        This is Companion object used to make static members of a
        Kotlin Class.
        We have made this class singleton as we don't want multiple concurrent
        types of Database calls to User Table
        @TODO: Might add locks to this class later to deal concurrency of methods
        @author : Pravesh Choudhary
     */
    companion object {
        private var INSTANCE: UserRepository? = null

        fun getInstance(): UserRepository {
            if (INSTANCE == null) {
                INSTANCE = UserRepository()
            }
            return INSTANCE!!
        }
    }

    /**
        @Method: Add User
        @param: user -- Details of user need to be added to database
        @return: Bool ( True -- If successfully added user to database,
                          False Otherwise )
        @TODO: Implementation Pending
        @author : Pravesh Choudhary
     */
    fun addUser(user: User): Boolean {
        throw NotImplementedError()
    }

    /**
        @Method: Login User
        @param: user -- Details of user need to be added to database
        @return: Bool ( True -- If login was successful,
        False Otherwise )
        @TODO: Implementation Pending
        @author : Pravesh Choudhary
     */
    fun login(name: String, password: String): Boolean {
        throw NotImplementedError()
    }

    /**
        @Method: Edit User
        @param: user -- Details of user need to be added to database
        @return: Bool ( True -- If edit call to database was successful,
        False Otherwise )
        @TODO: Implementation Pending
        @author : Pravesh Choudhary
     */
    fun editUser(user : User): Boolean {
        throw NotImplementedError()
    }
}