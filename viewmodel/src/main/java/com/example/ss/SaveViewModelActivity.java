package com.example.ss;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewmodel.R;

public class SaveViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);

        TextView tv = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button);

        // TODO 把开发者 - 不保留活动 开启
        MyViewModel viewModel = new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(MyViewModel.class);
        tv.setText("" + viewModel.getAge().getValue());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setAge(viewModel.getAge().getValue() + 1);
                tv.setText("" + viewModel.getAge().getValue());
            }
        });
    }
}