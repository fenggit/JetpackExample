package com.example.hilt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.hilt.inject.UserInfo;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

//  Expected @AndroidEntryPoint to have a value. Did you forget to apply the Gradle Plugin?
//        [Hilt] Processing did not complete. See error above for details.
//@AndroidEntryPoint
public class HiltActivity extends AppCompatActivity {

//    @Inject
    UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(v -> {
            Toast.makeText(this, userInfo.getName(), Toast.LENGTH_LONG).show();
        });

    }
}