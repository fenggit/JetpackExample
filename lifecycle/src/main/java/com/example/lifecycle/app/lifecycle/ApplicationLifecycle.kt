package com.example.lifecycle.app.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * 场景：整个APP的生命周期，与Activity数量无关的；
 *
 * 在Application#onCreate中调用： ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycle())
 *
 */
class ApplicationLifecycle : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        // 此方法只会调用一次
        Log.i("ApplicationLifecycle", ">>>>>>>>>>> onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i("ApplicationLifecycle", ">>>>>>>>>>> onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i("ApplicationLifecycle", ">>>>>>>>>>> onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onPause() {
        Log.i("ApplicationLifecycle", ">>>>>>>>>>> onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i("ApplicationLifecycle", ">>>>>>>>>>> onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        // 这个方法永远不会调用
        Log.i("ApplicationLifecycle", ">>>>>>>>>>> onDestroy")
    }
}