package com.example.myapplication.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplication.data.File
import com.example.myapplication.databinding.ActivityFileBinding
import com.example.myapplication.viewmodel.FileViewModel

class FileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFileBinding
    val viewModel = FileViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val file = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("file", File::class.java)
        } else {
            TODO("VERSION.SDK_INT < TIRAMISU")
        }
        Glide.with(this).load(file?.thumbnailUrl)
            .fitCenter()
            .into(binding.imgThumbnail)
        binding.txtTitle.text = file?.title
        binding.txtDescription.text = file?.description
        binding.btnDownload.setOnClickListener(View.OnClickListener {
            if (file != null) {
                viewModel.downLoadFile(file, this)
            }
        })
    }
}