package com.jiaopeng.commonsdk.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.gyf.immersionbar.ktx.immersionBar
import com.jiaopeng.commonsdk.R
import com.jiaopeng.commonsdk.event.AppViewModel
import com.jiaopeng.commonsdk.ext.dismissLoadingExt
import com.jiaopeng.commonsdk.ext.getAppViewModel
import com.jiaopeng.commonsdk.ext.getVmClazz
import com.jiaopeng.commonsdk.ext.showLoadingExt

/**
 * 描述：
 *
 * @author JiaoPeng by 2021/5/8
 */
abstract class BaseVMFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {

    //是否第一次加载
    private var isFirst: Boolean = true

    lateinit var mViewModel: VM

    lateinit var mViewBinding: VB

    lateinit var mActivity: AppCompatActivity

    //Application全局的ViewModel
    val appViewModel: AppViewModel by lazy { getAppViewModel() }

    abstract fun viewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun createObserver()

    /**
     * 懒加载
     */
    abstract fun lazyLoadData()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = viewBinding(inflater, container)
        mViewBinding.root.findViewById<Toolbar>(R.id.public_toolbar)?.let {
            immersionBar {
                titleBar(it)
                statusBarDarkFont(true, 0.2f)
                navigationBarColor(R.color.transparent)
            }
        }
        return mViewBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isFirst = true
        mViewModel = ViewModelProvider(this).get(getVmClazz(this))
        initView(savedInstanceState)
        createObserver()
        registerUiChange()
        initData()
    }

    private fun registerUiChange() {
        mViewModel.loadingChange.showDialog.observeInFragment(this) {
            showLoading(it)
        }
        mViewModel.loadingChange.dismissDialog.observeInFragment(this) {
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
     * Fragment执行onCreate后触发的方法
     */
    open fun initData() {}

    override fun onResume() {
        super.onResume()
        onVisible()
    }

    /**
     * 是否需要懒加载
     */
    private fun onVisible() {
        if (lifecycle.currentState == Lifecycle.State.STARTED && isFirst) {
            //等待view加载后触发懒加载
            view?.post {
                lazyLoadData()
                isFirst = false
            }
        }
    }
}