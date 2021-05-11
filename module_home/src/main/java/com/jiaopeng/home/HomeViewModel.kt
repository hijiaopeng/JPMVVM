package com.jiaopeng.home

import androidx.lifecycle.MutableLiveData
import com.jiaopeng.commonsdk.base.BaseViewModel
import com.jiaopeng.commonsdk.ext.request
import com.jiaopeng.commonsdk.state.ResultState

/**
 * 描述：
 *
 * @author JiaoPeng by 4/30/21
 */
class HomeViewModel : BaseViewModel() {

    var bannerData: MutableLiveData<ResultState<ArrayList<BannerResponse>>> = MutableLiveData()

    /**
     * 获取轮播图数据
     */
    fun getBannerData() {
        request({ homeService.getBanner() }, bannerData)
    }

}