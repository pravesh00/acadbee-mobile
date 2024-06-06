package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.data.Gender
import com.example.myapplication.data.Student
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.repository.FileRepository
import com.example.myapplication.repository.UserRepository
import com.example.myapplication.viewmodel.LoginViewModel
import kotlin.math.log

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
        val appDatabase = AppDatabase(this.applicationContext)
        loginViewModel.insertDummy(appDatabase)
        val root = binding.root
        setContentView(root)
    }

    private fun login() {
        val user = Student(binding.txtUserName.text.toString(),
            binding.txtPassword.text.toString())
        loginViewModel.setUser(user)
        loginViewModel.login(::onCallbackCalled)
    }
    private fun onCallbackCalled(check: Boolean){
        if(check){
            Toast.makeText(this, resources.getString(R.string.login_success), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }else {
            Toast.makeText(this, resources.getString(R.string.login_denied), Toast.LENGTH_SHORT).show()
        }
    }

    init {
        userRepository = UserRepository.getInstance()
        loginViewModel =  LoginViewModel(userRepository)
    }

}