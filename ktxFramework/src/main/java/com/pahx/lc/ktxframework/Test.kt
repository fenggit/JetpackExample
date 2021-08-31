package com.pahx.lc.ktxframework

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Test {
    suspend fun request():String {
        withContext(Dispatchers.IO) {
            delay(1000)
        }
        // 请求数据成功
        return "success"
    }

    fun test(){
        println("a")
        val handler = Handler(Looper.getMainLooper())
        handler.post {
            println("b")
        }
        println("c")
    }
}