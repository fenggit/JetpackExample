package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.databinding.ActivityRotateScreenBinding

/**
 * 场景：点击按钮增加数字,然后旋转屏幕后，数据丢失
 */
class RotateScreenActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityRotateScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRotateScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(NumberViewModel::class.java)

        binding.tvNumber.text = numberViewModel.number.toString()
        binding.btnAddNumber.setOnClickListener {
            numberViewModel.number++
            binding.tvNumber.text = numberViewModel.number.toString()
        }
    }
}