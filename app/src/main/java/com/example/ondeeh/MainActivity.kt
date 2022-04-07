package com.example.ondeeh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.ondeeh.databinding.ActivityMainBinding
import com.example.ondeeh.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)
        initDataBinding()
    }
    private fun initDataBinding() {
        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this
    }
}