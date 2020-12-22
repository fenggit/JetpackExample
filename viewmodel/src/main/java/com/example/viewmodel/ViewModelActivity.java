package com.example.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        TextView tv = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button);


        MyViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);

        viewModel.number.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tv.setText("" + integer);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.add();
            }
        });

        // 开发者模式 - 后台不保留数据
    }
}