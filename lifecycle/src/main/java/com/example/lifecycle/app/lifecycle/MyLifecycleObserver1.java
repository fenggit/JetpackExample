package com.example.lifecycle.app.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifecycleObserver1 implements LifecycleObserver {
    public static final String TAG = "MyLifecycleObserver1";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        // 此方法只会调用一次
        Log.i(TAG, ">>>>>>>>>>> onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        Log.i(TAG, ">>>>>>>>>>> onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        Log.i(TAG, ">>>>>>>>>>> onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onPause() {
        Log.i(TAG, ">>>>>>>>>>> onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        Log.i(TAG, ">>>>>>>>>>> onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Log.i(TAG, ">>>>>>>>>>> onDestroy");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner source, Lifecycle.Event event) {
        // 每个生命周期都会调用到一次
        Log.i(TAG, ">>>>>>>>>>> onAny:" + event.name());
    }
}
