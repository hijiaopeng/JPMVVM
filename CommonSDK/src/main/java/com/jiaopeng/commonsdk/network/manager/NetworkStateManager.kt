package com.jiaopeng.commonsdk.network.manager

import com.jiaopeng.commonsdk.event.EventLiveData

/**
 * 描述：
 *
 * @author JiaoPeng by 2021/5/7
 */
class NetworkStateManager private constructor() {

    val mNetworkStateCallback = EventLiveData<NetState>()

    companion object {
        val instance: NetworkStateManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkStateManager()
        }
    }

}