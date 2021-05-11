# JPMVVM
 基于MVVM-Coroutines-Arouter-Retrofit-Jetpack的Android项目框架
 
 简单的先写一下
 本项目是一个搭建好的框架，已经集成Coroutines、Arouter、Retrofit、Jetpack、blankj/UtilCodex、afollestad/material-dialogs、
 Coil、gyf-dev/ImmersionBar、JessYanCoding/AndroidAutoSize、MMKV。
 
 布局ID的获取使用ViewBinding，已经封装好，结合ViewModel一起使用。
 
 在Application中的初始化，现在使用App Startup。
 
 使用时添加Module即可。
 
 建议对于每一个第三方功能的实现，单独提出为Module。
 
 需要完善的地方：应该新建一个res公共资源Module，存放公共资源。
 
