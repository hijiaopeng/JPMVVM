package com.jiaopeng.commonsdk.ext

import android.app.Activity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter

/**
 * 描述：
 *
 * @author JiaoPeng by 4/28/21
 */
/**
 * 简单的跳转
 */
fun String.navigation() {
    ARouter.getInstance()
        .build(this)
        .navigation()
}

/**
 * 实现startActivityForResult形式跳转
 */
fun String.navigation4ActivityResult(activity: Activity, requestCode: Int) {
    ARouter.getInstance()
        .build(this)
        .navigation(activity, requestCode)
}

/**
 * 通过Bundle传递参数
 */
fun String.navigation(bundle: Bundle) {
    ARouter.getInstance()
        .build(this)
        .with(bundle)
        .navigation()
}

/**
 * 使用绿色通道（跳过所有的拦截器）
 */
fun String.navigation4Green() {
    ARouter.getInstance()
        .build(this)
        .greenChannel()
        .navigation()
}



















