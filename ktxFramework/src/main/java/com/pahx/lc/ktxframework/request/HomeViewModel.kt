package com.pahx.lc.ktxframework.request

import android.os.Looper
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pahx.lc.ktxframework.bean.BaseRes
import com.pahx.lc.ktxframework.bean.HomeResInfo
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class HomeViewModel : ViewModel() {
    var homeData = MutableLiveData<BaseRes<HomeResInfo>>()

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        //Log.e("hefeng", "Throws an exception with message: ${throwable.message}")
        Log.e("hefeng", Log.getStackTraceString(throwable))

    }

    fun requestHome(pageId: Int) {
        // 默认主线程
        viewModelScope.launch(exceptionHandler) {
            // 左边代码：主线程 ； 右边代码：「挂起执行异步线程，Retrofit已经处理」「执行完成后，恢复到主线程」
            homeData.value = HomeRepository().requestHome(pageId)
        }

//        viewModelScope.safeLaunch {
//            // 左边代码：主线程 ； 右边代码：「挂起执行异步线程，Retrofit已经处理」「执行完成后，恢复到主线程」
//            homeData.value = HomeRepository().requestHome(pageId)
//        }
    }

    fun CoroutineScope.safeLaunch(launchBody: suspend () -> Unit): Job {
        val coroutineExceptionHandler = CoroutineExceptionHandler {
                coroutineContext, throwable ->
            // handle thrown exceptions from coroutine scope
            throwable.printStackTrace()
        }

        return this.launch(coroutineExceptionHandler) {
            launchBody.invoke()
        }
    }

//    fun CoroutineScope.safeLaunch(block: suspend (coroutineScope: CoroutineScope) -> Unit,
//                                  fail: (t: Throwable) -> Unit = { },
//                                  toastNetWorkError: Boolean = true,
//                                  toastResponseError: Boolean = false): Job {
//        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
//            val isMainThread = Looper.getMainLooper().thread == Thread.currentThread()
//            exception.printStackTrace()
//            if (isMainThread && toastNetWorkError) {
//                checkToastNetWorkError(exception)
//            }
//            if (isMainThread && toastResponseError) {
//                checkToastResponseError(exception)
//            }
//            fail(exception)
//        }
//        return launch(exceptionHandler) { block(this) }
//    }
}