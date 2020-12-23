package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        getLifecycle().addObserver(new MyObserver());
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
    }
}