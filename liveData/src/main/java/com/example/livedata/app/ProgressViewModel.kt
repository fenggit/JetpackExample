package com.example.livedata.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProgressViewModel : ViewModel() {
    var progress: MutableLiveData<Int>? = null

    fun getProgressData(): MutableLiveData<Int> {
        if (progress == null) {
            progress = MutableLiveData()
            progress?.value = 0
        }

        return progress!!
    }
}