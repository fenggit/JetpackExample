package com.pahx.lc.ktxframework.http

interface ICallback {
    fun onSuccess(result: String)

    fun onError(errorCode: Int, errorMessage: String)

}