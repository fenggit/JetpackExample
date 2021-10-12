package com.example.jetpackexample

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.example.lifecycle.app.lifecycle.ApplicationLifecycle

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // 需要依赖：implementation 'androidx.lifecycle:lifecycle-process:2.3.1'
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycle())

    }
}