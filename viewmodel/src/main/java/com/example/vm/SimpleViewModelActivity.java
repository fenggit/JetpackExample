package com.example.vm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewmodel.R;

public class SimpleViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        TextView tv = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button);

        // 第一种方法
        MyViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        // 第二种方法
        //MyViewModel viewModel = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        // TODO 试试横竖屏看看，数据会不会丢失
        tv.setText(String.format("%d", viewModel.age));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.age = viewModel.age + 1;
                tv.setText(String.format("%d", viewModel.age));
            }
        });
    }
}