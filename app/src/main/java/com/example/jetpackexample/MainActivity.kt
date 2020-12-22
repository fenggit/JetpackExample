package com.example.jetpackexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.all.AllViewModelActivity
import com.example.livedata.LiveDataActivity
import com.example.ss.SaveViewModelActivity
import com.example.viewmodel.ViewModelActivity
import com.example.vm.SimpleViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button2.setOnClickListener {
            startActivity(Intent(this, LiveDataActivity::class.java))
        }

        button4.setOnClickListener {
            //startActivity(Intent(this, SimpleViewModelActivity::class.java))
            //startActivity(Intent(this, ViewModelActivity::class.java))
            //startActivity(Intent(this, SaveViewModelActivity::class.java))
            startActivity(Intent(this, AllViewModelActivity::class.java))
        }
    }
}