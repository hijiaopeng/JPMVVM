package com.jiaopeng.commonsdk.ext

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import coil.load
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.callbacks.onShow
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.jiaopeng.commonsdk.R
import com.jiaopeng.commonsdk.data.Constants

/**
 * 描述：弹窗扩展函数
 *
 * @author JiaoPeng by 4/30/21
 */

//请求网络的等待弹窗
private var loadingDialog: MaterialDialog? = null

/**
 * 打开等待框
 */
fun AppCompatActivity.showLoadingExt(message: String = "请求网络中") {
    if (!this.isFinishing) {
        if (loadingDialog == null) {
            loadingDialog = MaterialDialog(this)
                .show {
                    customView(R.layout.dialog_net_request)
                    lifecycleOwner(this@showLoadingExt)
                }
            loadingDialog?.onShow { dialog ->
                dialog.getCustomView().findViewById<ImageView>(R.id.iv_dialog_net_loading)
                    .load(R.drawable.loading)
                dialog.getCustomView().findViewById<TextView>(R.id.tv_dialog_net_loading)
                    .text(message)
            }
        }
    }
}

fun Fragment.showLoadingExt(message: String = "请求网络中") {
    activity?.let { act ->
        if (!act.isFinishing) {
            if (loadingDialog == null) {
                loadingDialog = MaterialDialog(act)
                    .show {
                        customView(R.layout.dialog_net_request)
                        lifecycleOwner(this@showLoadingExt)
                    }
                loadingDialog?.onShow { dialog ->
                    dialog.getCustomView().findViewById<ImageView>(R.id.iv_dialog_net_loading)
                        .load(R.drawable.loading)
                    dialog.getCustomView().findViewById<TextView>(R.id.tv_dialog_net_loading)
                        .text(message)
                }
            }
        }
    }
}

/**
 * 关闭等待框
 */
fun AppCompatActivity.dismissLoadingExt() {
    loadingDialog?.dismiss()
    loadingDialog = null
}

/**
 * 关闭等待框
 */
fun Fragment.dismissLoadingExt() {
    loadingDialog?.dismiss()
    loadingDialog = null
}