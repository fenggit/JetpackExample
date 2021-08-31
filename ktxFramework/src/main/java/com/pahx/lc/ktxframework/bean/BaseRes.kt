package com.pahx.lc.ktxframework.bean

class BaseRes<T> {
    var errorCode: Int? = 0
    var errorMsg: String? = null
    var data: T? = null
}