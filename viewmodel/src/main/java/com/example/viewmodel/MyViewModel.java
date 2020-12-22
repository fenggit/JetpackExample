package com.example.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> _number = new MutableLiveData<>();

    public LiveData<Integer> number = _number;

    public void add() {
        if (_number.getValue() == null) {
            _number.setValue(1);
        } else {
            _number.setValue(_number.getValue() + 1);
        }
    }

}
