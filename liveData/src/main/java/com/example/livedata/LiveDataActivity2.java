package com.example.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.Toast;

public class LiveDataActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data2);

        findViewById(R.id.button2).setOnClickListener(v -> {
            LiveDataBus.getDefault().with("LiveDataActivity").setValue("page2");
        });

        LiveDataBus.getDefault().with("LiveDataActivity2", String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getApplicationContext(), "page2数据：" + s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LiveDataBus.getDefault().remove("LiveDataActivity2");
    }
}