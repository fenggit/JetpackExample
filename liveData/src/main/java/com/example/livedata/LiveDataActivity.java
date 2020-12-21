package com.example.livedata;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class LiveDataActivity extends AppCompatActivity {
    private MutableLiveData<String> liveData; // Handler
    //private MutableLiveData<Message> liveData; // Handler

    // Handler 会持有生命周期

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        setListener();

        liveData = new MutableLiveData<>();
        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // 自动切换线程的，感知生命周期，页面可见的时候处理，相同的消息只会处理一次，消息是有序的
                Toast.makeText(getApplicationContext(), "收到的数据：" + s, Toast.LENGTH_SHORT).show();
                Log.e("he", s);
                tv.setText(s);
            }
        });

        LiveDataBus.getDefault().with("LiveDataActivity", String.class).observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getApplicationContext(), "收到的数据：" + s, Toast.LENGTH_SHORT).show();
                tv.setText(s);
            }
        });
    }

    void setListener() {
        tv = findViewById(R.id.textView);
        findViewById(R.id.button).setOnClickListener(v -> {
            // 同一个线程，主线程
            liveData.setValue("主线程");
            // 不同线程，子线程
            //liveData.postValue("yes");
        });

        findViewById(R.id.button1).setOnClickListener(v -> {
            new Thread(() -> {
                SystemClock.sleep(5000);
                // java.lang.IllegalStateException: Cannot invoke setValue on a background thread
                //liveData.setValue("子线程:setValue");
                liveData.postValue("子线程:postValue");
            }).start();
        });

        findViewById(R.id.button2).setOnClickListener(v -> {
            // 粘性事件
            // 先发送事件，接收者还没注册
            LiveDataBus.getDefault().with("LiveDataActivity2", String.class).setValue("page");
            startActivity(new Intent(this, LiveDataActivity2.class));
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        LiveDataBus.getDefault().remove("LiveDataActivity");
    }
}