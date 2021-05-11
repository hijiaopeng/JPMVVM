package com.jiaopeng.commonsdk.ext

import android.view.View
import com.blankj.utilcode.util.ClickUtils

/**
 * 描述：
 *
 * @author JiaoPeng by 4/29/21
 */
/**
 * View点击事件防抖
 */
fun View.onSingleClick(block: () -> Unit) = setOnClickListener {
    ClickUtils.applySingleDebouncing(this, 800) {
        block.invoke()
    }
}