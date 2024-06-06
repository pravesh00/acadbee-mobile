package com.example.myapplication.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.User
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.repository.FileRepository
import com.example.myapplication.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

class LoginViewModel(
    private var userRepository: UserRepository
): BaseViewModel() {
    var user: MutableLiveData<User> = MutableLiveData()

    fun setUser(givenUser : User){
        this.user.value = givenUser
    }
    fun login(onCallbackCalled: (Boolean) -> Unit) {
        if(user.value == null)
            throw NullPointerException()
        else viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    userRepository.login(user.value!!.userName, user.value!!.password)
                }
                onCallbackCalled(result)
            } catch (e: Exception) {
                onCallbackCalled(false)
            }
        }
    }

    fun insertDummy(appDatabase: AppDatabase) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                   FileRepository.getInstance().addDummyData(appDatabase)
                }

            } catch (e: Exception) {

            }
        }
    }
}