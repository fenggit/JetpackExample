package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.lifecycle.app.gps.GPSService;
import com.example.lifecycle.app.lifecycle.MyLifecycleObserver1;
import com.example.lifecycle.app.lifecycle.MyLifecycleObserver2;
import com.example.lifecycle.app.lifecycle.MyService;
import com.example.lifecycle.app.timer.UserUseTimeActivity2;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

//        getLifecycle().addObserver(new MyObserver());
//        getLifecycle().addObserver(new MyLifecycleObserver1());
//        getLifecycle().addObserver(new MyLifecycleObserver2());

        //startActivity(new Intent(this, UserUseTimeActivity.class));
//        startActivity(new Intent(this, UserUseTimeActivity2.class));

        //startService(new Intent(this, GPSService.class));
        startService(new Intent(this, MyService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("he", "Activity onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("he", "Activity onStop");

        //stopService(new Intent(this, GPSService.class));
        stopService(new Intent(this, MyService.class));
    }
}