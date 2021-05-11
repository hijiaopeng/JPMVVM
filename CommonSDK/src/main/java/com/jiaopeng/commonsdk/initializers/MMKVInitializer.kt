package com.jiaopeng.commonsdk.initializers

import android.content.Context
import androidx.startup.Initializer
import com.tencent.mmkv.MMKV

/**
 * 描述：MMKV初始化
 *
 * @author JiaoPeng by 2021/5/8
 */
class MMKVInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        MMKV.initialize(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

}