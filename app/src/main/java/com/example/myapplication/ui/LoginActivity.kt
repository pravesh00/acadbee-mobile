package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.data.Gender
import com.example.myapplication.data.Student
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.repository.UserRepository
import com.example.myapplication.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var userRepository :UserRepository
    private var loginViewModel :LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.button.setOnClickListener(View.OnClickListener {
            login()
        })

        val root = binding.root
        setContentView(root)
    }

    private fun login() {
        val user = Student(binding.txtUserName.text.toString(),
            binding.txtPassword.text.toString(),
            Gender.MALE,
            "",
            "",
            1999,
            2001
            )
        loginViewModel.setUser(user)
        val check = loginViewModel.login()
        if(check){
            Toast.makeText(this, "Login Done", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show()
        }
    }

    init {
        userRepository = UserRepository.getInstance()
        loginViewModel =  LoginViewModel(userRepository)
    }

}