package com.example.app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

/**
 * 用ViewModel解决数据丢失问题
 */
class NumberViewModel2(application: Application) : AndroidViewModel(application) {
    var number: Int = 0
}