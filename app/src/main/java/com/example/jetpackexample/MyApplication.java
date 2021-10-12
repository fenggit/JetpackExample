package com.example.jetpackexample;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        ProcessLifecycleOwner.get().getLifecycle().addObserver(ApplicationLifecycle());
    }
}
