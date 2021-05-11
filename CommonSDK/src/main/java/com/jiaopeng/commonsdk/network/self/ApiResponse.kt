package com.jiaopeng.commonsdk.network.self

import com.jiaopeng.commonsdk.network.BaseResponse

/**
 * 描述：服务器返回数据的基类
 *
 * @author JiaoPeng by 2021/5/8
 */
data class ApiResponse<T>(val errorCode: Int, val errorMsg: String, val data: T) :
    BaseResponse<T>() {

    override fun isSuccess(): Boolean = errorCode == 0

    override fun getResponseCode() = errorCode

    override fun getResponseData() = data

    override fun getResponseMsg() = errorMsg

}