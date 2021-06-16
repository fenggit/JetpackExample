package com.example.lifecycle.app.gps

import androidx.lifecycle.LifecycleService

/**
 * 使用场景：GPS位置定位功能
 * 需要引入：implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
 */
class GPSService : LifecycleService() {
    init {
        val gpsObserver = GPSObserver(this)
        lifecycle.addObserver(gpsObserver)
    }
}