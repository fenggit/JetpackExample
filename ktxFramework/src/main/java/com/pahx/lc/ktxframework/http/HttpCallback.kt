package com.pahx.lc.ktxframework.http

import com.google.gson.Gson
import java.lang.reflect.ParameterizedType

/**
 * 抽象类的作用：HTTP 通用接口
 */
abstract class HttpCallback<T> : ICallback {
    val mGson by lazy { Gson() }

    override fun onSuccess(result: String) {
        val cls: Class<*> = getTClass(this as Object)
        val t: T = mGson.fromJson(result, cls) as T
        onSuccess(t)
    }

    override fun onError(errorCode: Int, errorMessage: String) {

    }

    abstract fun onSuccess(info: T)

    /**
     * 获取 HttpCallback<T> 中的 T 的 class
     */
    fun getTClass(obj: Object): Class<*> {
        val genType = obj.`class`.genericSuperclass
        val actualTypeArray = (genType as ParameterizedType).actualTypeArguments
        // 0是指HttpCallback种的第一个泛型的值
        return actualTypeArray[0] as Class<*>
    }

}