package com.jiaopeng.commonsdk.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.gyf.immersionbar.ktx.immersionBar
import com.jiaopeng.commonsdk.R
import com.jiaopeng.commonsdk.event.AppViewModel
import com.jiaopeng.commonsdk.ext.dismissLoadingExt
import com.jiaopeng.commonsdk.ext.getAppViewModel
import com.jiaopeng.commonsdk.ext.getVmClazz
import com.jiaopeng.commonsdk.ext.showLoadingExt
import com.jiaopeng.commonsdk.network.manager.NetState
import com.jiaopeng.commonsdk.network.manager.NetworkStateManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * 描述：
 *
 * @author JiaoPeng by 4/30/21
 */
abstract class BaseVMActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity(),
    CoroutineScope {
    /**
     * ViewModel对象
     */
    lateinit var mViewModel: VM

    lateinit var mViewBinding: VB

    //Application全局的ViewModel
    val appViewModel: AppViewModel by lazy { getAppViewModel() }

    /**
     * 对ViewBinding进行封装
     */
    abstract fun viewBinding(): VB

    abstract fun initView(savedInstanceState: Bundle?)

    /**
     * 创建LiveData数据观察者
     */
    abstract fun createObserver()

    private val mJob = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + mJob

    open lateinit var mCoroutineScope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = viewBinding()
        mViewModel = ViewModelProvider(this).get(getVmClazz(this))
        mViewBinding.root.findViewById<Toolbar>(R.id.public_toolbar)?.let {
            immersionBar {
                titleBar(it)
                statusBarDarkFont(true, 0.2f)
                navigationBarColor(R.color.transparent)
            }
        }
        setContentView(mViewBinding.root)
        mCoroutineScope = CoroutineScope(coroutineContext)
        ARouter.getInstance().inject(this)
        registerUiChange()
        initView(savedInstanceState)
        createObserver()
        NetworkStateManager.instance.mNetworkStateCallback.observeInActivity(this, Observer {
            onNetworkStateChanged(it)
        })
    }

    /**
     * 注册UI 事件
     */
    private fun registerUiChange() {
        //显示弹窗
        mViewModel.loadingChange.showDialog.observeInActivity(this) {
            showLoading(it)
        }
        //关闭弹窗
        mViewModel.loadingChange.dismissDialog.observeInActivity(this) {
            dismissLoading()
        }
    }

    /**
     * 显示弹窗
     */
    open fun showLoading(message: String = "请求网络中...") {
        showLoadingExt(message)
    }

    /**
     * 关闭弹窗
     */
    open fun dismissLoading() {
        dismissLoadingExt()
    }

    /**
     * 网络变化监听
     */
    open fun onNetworkStateChanged(netState: NetState) {}

    override fun onDestroy() {
        super.onDestroy()
        mJob.cancel()
    }

}