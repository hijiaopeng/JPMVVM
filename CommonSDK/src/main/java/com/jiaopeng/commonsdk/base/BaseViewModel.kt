package com.jiaopeng.commonsdk.base

import androidx.lifecycle.ViewModel
import com.jiaopeng.commonsdk.event.EventLiveData

/**
 * 描述：
 *
 * @author JiaoPeng by 4/30/21
 */
open class BaseViewModel : ViewModel() {

    val loadingChange: UiLoadingChange by lazy { UiLoadingChange() }

    inner class UiLoadingChange {
        //显示加载框
        val showDialog by lazy { EventLiveData<String>() }
        //隐藏
        val dismissDialog by lazy { EventLiveData<Boolean>() }
    }

}