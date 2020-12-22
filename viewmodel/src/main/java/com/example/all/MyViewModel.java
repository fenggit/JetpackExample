package com.example.all;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private SavedStateHandle savedStateHandle;
    public static final String AGE_KEY = "com.example.all.AGE_KEY";

    private MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();

    public MyViewModel(SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;
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
