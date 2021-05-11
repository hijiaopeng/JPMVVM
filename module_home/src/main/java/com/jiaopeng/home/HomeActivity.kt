package com.jiaopeng.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.jiaopeng.commonsdk.base.BaseVMActivity
import com.jiaopeng.commonsdk.data.Constants
import com.jiaopeng.commonsdk.ext.mmkv
import com.jiaopeng.commonsdk.ext.onSingleClick
import com.jiaopeng.commonsdk.ext.parseState
import com.jiaopeng.home.databinding.ActivityHomeBinding

@Route(path = Constants.Acts.ACT_HOME)
class HomeActivity : BaseVMActivity<HomeViewModel, ActivityHomeBinding>() {

    val bundle: String? by lazy {
        intent.extras?.getString("123")
    }

    override fun viewBinding(): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        mViewBinding.tvHome.onSingleClick {
            Toast.makeText(this, "${bundle}", Toast.LENGTH_SHORT).show()
//            mViewModel.getBannerData()
//            Constants.Acts.ACT_LOGIN.navigation()
        }
    }

    override fun createObserver() {
        mViewModel.run {
            bannerData.observe(this@HomeActivity, { resultState ->
                parseState(resultState, { data ->
                    data.forEach {
                        Log.e("JP", "createObserver: ${it}")
                    }
                })
            })
        }
    }
}