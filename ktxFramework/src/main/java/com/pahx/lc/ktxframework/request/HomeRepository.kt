package com.pahx.lc.ktxframework.request

import com.pahx.lc.ktxframework.bean.BaseRes
import com.pahx.lc.ktxframework.bean.HomeResInfo
import com.pahx.lc.ktxframework.lib.RequestManager

class HomeRepository {
    suspend fun requestHome(pageId: Int): BaseRes<HomeResInfo> {
        return RequestManager.instance.instanceRetrofit(HomeAPI::class.java).requestHome(pageId)
    }
}