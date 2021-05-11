package com.jiaopeng.commonsdk.ext

import com.tencent.mmkv.MMKV

/**
 * 描述：MMKV的扩展函数
 *
 * @author JiaoPeng by 2021/5/8
 */
/**
 * 获取MMKV对象
 */
val mmkv: MMKV? by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    MMKV.defaultMMKV()
}

