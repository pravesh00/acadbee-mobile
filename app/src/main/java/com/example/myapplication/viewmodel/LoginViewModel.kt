package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.User
import com.example.myapplication.repository.UserRepository

class LoginViewModel(
    private var userRepository: UserRepository
): BaseViewModel() {
    var user: MutableLiveData<User> = MutableLiveData()

    fun setUser(givenUser : User){
        this.user.value = givenUser
    }
    fun login(): Boolean {
        if(user.value == null)
            throw NullPointerException()
        return userRepository.login(user.value!!.userName, user.value!!.password)
    }
}