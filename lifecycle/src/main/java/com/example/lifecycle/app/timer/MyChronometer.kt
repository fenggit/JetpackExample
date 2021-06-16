package com.example.lifecycle.app.timer

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 解耦合，降低复杂度，
 * LifecycleObserver 不需要引入任何jar包，只要是AndroidX就行
 */
class MyChronometer(context: Context?, attrs: AttributeSet?) :
    Chronometer(context, attrs), LifecycleObserver {

    var elapsedTime = 0L

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startTime() {
        // 设置开机时间为基准，减去不在使用的时间，就是app放到后台的时候
        base = SystemClock.elapsedRealtime() - elapsedTime
        start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopTime() {
        elapsedTime = SystemClock.elapsedRealtime() - base
        stop()
    }
}