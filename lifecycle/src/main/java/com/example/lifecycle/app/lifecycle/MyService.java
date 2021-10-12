package com.example.lifecycle.app.lifecycle;

import androidx.lifecycle.LifecycleService;

public class MyService extends LifecycleService {
    @Override
    public void onCreate() {
        super.onCreate();
        getLifecycle().addObserver(new MyLifecycleObserver1());
    }
}
