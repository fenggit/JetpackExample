package com.example.lifecycle.app.lifecycle;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifecycleObserver2 implements LifecycleEventObserver {
    public static final String TAG = "MyLifecycleObserver2";

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        Log.i(TAG, ">>>>>>>>>>>" + event.name());
    }
}
