package com.pahx.lc.ktxframework.lib

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RequestManager {
    private object Holder {
        val INSTANACE = RequestManager()
    }

    companion object {
        val instance = Holder.INSTANACE
    }

    fun <T> instanceRetrofit(apiService: Class<T>): T {
        val log = HttpLoggingInterceptor()
        log.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient().newBuilder().myApply {
            readTimeout(10, TimeUnit.SECONDS)
            connectTimeout(10, TimeUnit.SECONDS)
            writeTimeout(10, TimeUnit.SECONDS)
            //addNetworkInterceptor(log)
        }.build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(apiService)
    }

    fun <T> T.myApply(rm: T.() -> Unit): T {
        rm()
        return this
    }
}