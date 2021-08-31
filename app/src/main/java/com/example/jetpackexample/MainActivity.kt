package com.example.jetpackexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import com.example.all.AllViewModelActivity
import com.example.app.RotateScreenActivity
import com.example.app.RotateScreenActivity2
import com.example.lifecycle.LifeCycleActivity
import com.example.livedata.LiveDataActivity
import com.example.livedata.app.LiveDataPageActivity
import com.pahx.lc.ktxframework.RequestMainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener {
            //startActivity(Intent(this, LiveDataActivity::class.java))
            startActivity(Intent(this, LiveDataPageActivity::class.java))
        }

        button3.setOnClickListener {
            startActivity(Intent(this, LifeCycleActivity::class.java))
        }

        button4.setOnClickListener {
            //startActivity(Intent(this, SimpleViewModelActivity::class.java))
            //startActivity(Intent(this, ViewModelActivity::class.java))
            //startActivity(Intent(this, SaveViewModelActivity::class.java))
            //startActivity(Intent(this, AllViewModelActivity::class.java))
            startActivity(Intent(this, RotateScreenActivity::class.java))
            //startActivity(Intent(this, RotateScreenActivity2::class.java))
        }
        button5.setOnClickListener {
            startActivity(Intent(this, RequestMainActivity::class.java))
//            for (i in 0..10) {
//                test()
//            }
        }
    }


    // 答案：acb
    fun test() {
        println("a")
        val handler = Handler(Looper.getMainLooper())
        handler.post {
            println("b")
        }
        //Thread.sleep(200)
        println("c")
    }
}