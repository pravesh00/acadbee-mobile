package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.File
import com.example.myapplication.repository.FileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

class HomeViewModel : ViewModel() {
    val filesList = MutableLiveData<ArrayList<File>>()
    private val fileRepository = FileRepository.getInstance()

    fun refresh() {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    fileRepository.getFiles()
                }
                var list: List<File> = result
                filesList.postValue(list as ArrayList<File>?)
            } catch (e: Exception) {

            }
        }
    }

}