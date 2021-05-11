package com.jiaopeng.commonsdk.data

/**
 * 描述：
 *
 * @author JiaoPeng by 4/27/21
 */
object Constants {

    object GroupUrl {
        const val GROUP_APP = "/app"
        const val GROUP_HOME = "/home"
        const val GROUP_LOGIN = "/login"
    }

    /**
     * Activity路由路径
     */
    object Acts {
        const val ACT_APP_MAIN = "${GroupUrl.GROUP_APP}/MainActivity"
        const val ACT_HOME= "${GroupUrl.GROUP_HOME}/HomeActivity"
        const val ACT_LOGIN= "${GroupUrl.GROUP_LOGIN}/LoginActivity"
    }

    object Static{
       const val URL_NET_DIALOG = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fc67bcdfe10d5201067157ff7376414c6a9f9900437c69-EndxN7_fw658&refer=http%3A%2F%2Fhbimg.b0.upaiyun.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622365456&t=66ffeba311aaa71e60628ea7065c3823"
    }


}