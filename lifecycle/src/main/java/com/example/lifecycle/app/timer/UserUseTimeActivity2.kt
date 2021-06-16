package com.example.lifecycle.app.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lifecycle.databinding.ActivityUserUseTime2Binding

/**
 * 统计：用户使用APP时长，不包括App停留在后台；
 *
 * 解决耦合，chronometer和activity生命周期有关
 */
class UserUseTimeActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityUserUseTime2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserUseTime2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 加入监听
        lifecycle.addObserver(binding.chronometer)
    }
}