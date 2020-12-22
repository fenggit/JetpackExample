package com.example.all;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.viewmodel.R;

public class AllViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        TextView tv = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button);

        // TODO :测试横竖屏和开发者模式-不保留活动信息
        MyViewModel myViewModel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(MyViewModel.class);
        myViewModel.getAge().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tv.setText("" + integer);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setAge(myViewModel.getAge().getValue() + 1);
            }
        });
    }
}