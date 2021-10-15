package com.example.hilt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hilt.dagger.User;

import javax.inject.Inject;

import dagger.android.DaggerApplication;

public class MainActivity extends AppCompatActivity {

    @Inject
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}