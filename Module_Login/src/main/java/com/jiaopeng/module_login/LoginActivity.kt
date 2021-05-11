package com.jiaopeng.module_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jiaopeng.commonsdk.data.Constants
import com.jiaopeng.module_login.databinding.ActivityLoginBinding

@Route(path = Constants.Acts.ACT_LOGIN)
class LoginActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        ARouter.getInstance().inject(this)

    }
}