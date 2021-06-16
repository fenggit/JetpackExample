package com.example.app

import androidx.lifecycle.ViewModel

/**
 * 用ViewModel解决数据丢失问题
 */
class NumberViewModel : ViewModel() {
    var number: Int = 0
}