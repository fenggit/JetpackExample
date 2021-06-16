package com.example.lifecycle.app.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.lifecycle.databinding.ActivityUserUseTimeBinding

/**
 * 统计：用户使用APP时长，不包括App停留在后台；
 *
 * 耦合度高，chronometer和activity生命周期有关
 */
class UserUseTimeActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserUseTimeBinding
    var elapsedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_user_use_time)
        binding = ActivityUserUseTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        // 设置开机时间为基准，减去不在使用的时间，就是app放到后台的时候
        binding.chronometer.base = SystemClock.elapsedRealtime() - elapsedTime
        binding.chronometer.start()
    }

    override fun onPause() {
        super.onPause()
        elapsedTime = SystemClock.elapsedRealtime() - binding.chronometer.base
        binding.chronometer.stop()
    }
}