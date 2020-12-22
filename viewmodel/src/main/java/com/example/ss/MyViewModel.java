package com.example.ss;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

// VM层，存放各种数据
public class MyViewModel extends ViewModel {
    private SavedStateHandle savedStateHandle;
    public static final String AGE_KEY = "com.example.ss.AGE_KEY";

    public MyViewModel(SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;
        Log.e("he", "SavedStateHandle:" + savedStateHandle);
    }

    public MutableLiveData<Integer> getAge() {
        if (!savedStateHandle.contains(AGE_KEY)) {
            savedStateHandle.set(AGE_KEY, 0);
        }
        return savedStateHandle.getLiveData(AGE_KEY);
    }

    public void setAge(int age) {
        savedStateHandle.set(AGE_KEY, age);
    }
}
