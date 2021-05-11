package com.jiaopeng.commonsdk.network.self

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * 描述：自定义头部拦截器。传入heads，根据自己的规则进行修改
 *
 * @author JiaoPeng by 2021/5/8
 */
class MyHeadInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("token", "token123456").build()
        builder.addHeader("device", "Android").build()
        builder.addHeader("isLogin", "false").build()
        return chain.proceed(builder.build())
    }

}