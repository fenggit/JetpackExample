package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewmodel.databinding.ActivityRotateScreenBinding

/**
 * 场景：点击按钮增加数字,然后旋转屏幕后，数据丢失
 */
class RotateScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivityRotateScreenBinding

    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRotateScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvNumber.text = number.toString()
        binding.btnAddNumber.setOnClickListener {
            number++
            binding.tvNumber.text = number.toString()
        }
    }
}