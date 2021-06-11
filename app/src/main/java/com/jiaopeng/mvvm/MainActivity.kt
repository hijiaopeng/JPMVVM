package com.jiaopeng.mvvm

import android.os.Bundle
import androidx.core.os.bundleOf
import com.alibaba.android.arouter.facade.annotation.Route
import com.jiaopeng.commonsdk.base.BaseVMActivity
import com.jiaopeng.commonsdk.data.Constants
import com.jiaopeng.commonsdk.ext.navigation
import com.jiaopeng.commonsdk.ext.onSingleClick
import com.jiaopeng.mvvm.databinding.ActivityMainBinding

@Route(path = Constants.Acts.ACT_APP_MAIN)
class MainActivity : BaseVMActivity<MainViewModel, ActivityMainBinding>() {

    override fun viewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
        mViewBinding.tvSkip.onSingleClick {
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