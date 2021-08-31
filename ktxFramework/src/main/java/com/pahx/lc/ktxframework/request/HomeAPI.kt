package com.pahx.lc.ktxframework.request

import com.pahx.lc.ktxframework.bean.BaseRes
import com.pahx.lc.ktxframework.bean.HomeResInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeAPI {
    /**
     * https://www.wanandroid.com/blog/show/2
     */
    @GET("/article/list/{pageId}/json")
    suspend fun requestHome(@Path("pageId") pageId: Int): BaseRes<HomeResInfo>

    /**
     * https://www.wanandroid.com/blog/show/2
     */
    @GET("/article/list/{pageId}/json")
    fun requestHomeV2(@Path("pageId") pageId: Int): Call<BaseRes<HomeResInfo>>
}