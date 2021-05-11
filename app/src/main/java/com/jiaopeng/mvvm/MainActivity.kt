package com.jiaopeng.mvvm

import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import coil.load
import com.alibaba.android.arouter.facade.annotation.Route
import com.jiaopeng.commonsdk.base.BaseVMActivity
import com.jiaopeng.commonsdk.data.Constants
import com.jiaopeng.commonsdk.ext.mmkv
import com.jiaopeng.commonsdk.ext.navigation
import com.jiaopeng.commonsdk.ext.onSingleClick
import com.jiaopeng.commonsdk.ext.showToast
import com.jiaopeng.mvvm.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Route(path = Constants.Acts.ACT_APP_MAIN)
class MainActivity : BaseVMActivity<MainViewModel, ActivityMainBinding>() {

    override fun viewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        var a = 0
        var b = 1
        mViewBinding.tvSkip.onSingleClick {
//            a = b.also { b = a }
//            showToast("$a")
//            showLoading()
//            mViewBinding.ivGif.load(R.drawable.loading)
//            GlobalScope.launch {
//                delay(5000)
//                dismissLoading()
//            }
            Constants.Acts.ACT_HOME.navigation(
                bundleOf(
                    "123" to "123"
                )
            )
        }
    }

    override fun createObserver() {

    }

}