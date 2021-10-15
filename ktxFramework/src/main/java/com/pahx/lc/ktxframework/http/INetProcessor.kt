package com.pahx.lc.ktxframework.http

import kotlin.collections.HashMap

/**
 * 顶层的设计，目的为了生命周期
 */
interface INetProcessor {
    fun post(url: String, params: HashMap<String, Object>)
}