package com.example.myapplication.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.File
import com.example.myapplication.repository.FileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    val filesList = MutableLiveData<ArrayList<File>>()
    private val fileRepository = FileRepository.getInstance()

    fun refresh(appDatabase: Context) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    fileRepository.getFiles(appDatabase)
                }
                var list: List<File> = result
                filesList.postValue(list as ArrayList<File>?)
            } catch (e: Exception) {

            }
        }
    }

}