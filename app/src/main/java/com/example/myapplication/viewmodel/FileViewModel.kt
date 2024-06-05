package com.example.myapplication.viewmodel

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.File
import com.example.myapplication.util.DownloadFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FileViewModel: BaseViewModel() {

    fun downLoadFile(file : File, context: Context) {
        viewModelScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    DownloadFile.downLoadUrl(file.url ,context, file.title)
                }

            } catch (e: Exception) {

            }
        }
    }
}