package com.jiaopeng.home

import com.jiaopeng.commonsdk.network.self.ApiResponse
import com.jiaopeng.commonsdk.network.self.NetWorkApi
import retrofit2.http.GET

/**
 * 描述：
 *
 * @author JiaoPeng by 2021/5/8
 */

//双重校验锁式-单例 封装NetApiService 方便直接快速调用简单的接口
val homeService: HomeService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    NetWorkApi.INSTANCE.getApi(HomeService::class.java, HomeService.SERVER_URL)
}

interface HomeService {

    companion object{
        const val SERVER_URL = "https://wanandroid.com/"
    }

    /**
     * 获取banner数据
     */
    @GET("banner/json")
    suspend fun getBanner(): ApiResponse<ArrayList<BannerResponse>>

}