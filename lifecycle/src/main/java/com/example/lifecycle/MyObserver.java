package com.example.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onResume() {
        Log.e("he", "MyObserver onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {
        Log.e("he", "MyObserver onStop");
    }
}
