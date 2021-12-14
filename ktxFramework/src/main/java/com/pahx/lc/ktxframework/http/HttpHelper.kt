package com.pahx.lc.ktxframework.http

/**
 * 单例，给外部使用的接口
 *
 * ARouter 三个核心
 * - 内存优化
 * - 编译时注解
 */
class HttpHelper : INetProcessor {
    var mINetProcessor: INetProcessor? = null

    companion object {
        private var instance: HttpHelper? = null
            get() {
                if (instance == null) {
                    instance = HttpHelper()
                }
                return instance
            }

        @Synchronized
        fun instance(): INetProcessor {
            return instance!!
        }

    }

    fun init(netProcessor: INetProcessor) {
        mINetProcessor = netProcessor
    }

    override fun post(url: String, params: HashMap<String, Object>) {
        mINetProcessor!!.post(url, params)
    }
}