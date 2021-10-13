package com.example.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LiveDataMutActivity extends AppCompatActivity {
    TextView textView;

    // 合并MutableLiveData，统一处理
    MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();

    MutableLiveData<String> liveData1 = new MutableLiveData<>();
    MutableLiveData<String> liveData2 = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_mut);
        textView = findViewById(R.id.textView3);

        mediatorLiveData.addSource(liveData1, observe);
        mediatorLiveData.addSource(liveData2, observe);
        // 一定要加上这个监听
        mediatorLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // 统一处理数据
                textView.setText(s);
            }
        });

        // 发送消息
        findViewById(R.id.button3).setOnClickListener(view -> {
            liveData1.setValue("button1");
        });

        findViewById(R.id.button4).setOnClickListener(view -> {
            liveData2.setValue("button2");
        });

        findViewById(R.id.button5).setOnClickListener(view -> {
            mediatorLiveData.setValue("button3");
        });

        findViewById(R.id.button6).setOnClickListener(view -> {
            liveData.setValue("10");
        });

        //change();
        switchLiveData();
    }

    Observer<String> observe = new Observer<String>() {
        @Override
        public void onChanged(String s) {
            // 一定要加上，设置消息统一处理
            mediatorLiveData.setValue(s);
        }
    };

    MutableLiveData<String> liveData = new MutableLiveData<>();

    void change() {
        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // 转换前的数据
                Log.e("hefeng", "转换前的数据:" + s);
            }
        });
        // 将 String 转成 Int
        LiveData<Integer> transformedLiveData = Transformations.map(liveData, new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return Integer.parseInt(input) * 100;
            }
        });
        transformedLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                // 转换后的数据
                Log.e("hefeng", "转换前的数据:" + integer);
            }
        });
    }

    MutableLiveData<Integer> switchLiveData = new MutableLiveData<>();
//    MutableLiveData<String> liveData1 = new MutableLiveData<>();
//    MutableLiveData<String> liveData2 = new MutableLiveData<>();

    void switchLiveData() {
//        liveData1.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                // 转换前的数据
//                Log.e("hefeng", "监听数据源1:" + s);
//            }
//        });
//
//        liveData2.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                // 转换前的数据
//                Log.e("hefeng", "监听数据源2:" + s);
//            }
//        });

        LiveData<String> transformedLiveData = Transformations.switchMap(switchLiveData, new Function<Integer, LiveData<String>>() {
            @Override
            public LiveData<String> apply(Integer input) {
                if (input == 2) {
                    return liveData2;
                } else {
                    return liveData1;
                }
            }
        });
        transformedLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // 转换后的数据
                Log.e("hefeng", "监听到的数据:" + s);
            }
        });

        // 切换到第二个监听
        switchLiveData.setValue(2);
    }
}