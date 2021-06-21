package com.example.livedata.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.livedata.databinding.ActivityLiveDataPageBinding

/**
 * 场景：两个fragment之间的通信
 */
class LiveDataPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLiveDataPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}