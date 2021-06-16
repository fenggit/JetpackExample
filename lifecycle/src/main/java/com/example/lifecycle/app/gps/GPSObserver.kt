package com.example.lifecycle.app.gps

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class GPSObserver(var context: Context) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun startLocation() {
        Log.e("GPSObserver", "GPSObserver startLocation")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stopLocation() {
        Log.e("GPSObserver", "GPSObserver stopLocation")
    }
}




