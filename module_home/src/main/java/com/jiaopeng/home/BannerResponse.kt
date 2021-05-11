package com.jiaopeng.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 描述：
 *
 * @author JiaoPeng by 2021/5/8
 */
@Parcelize
data class BannerResponse(
    var desc: String = "",
    var id: Int = 0,
    var imagePath: String = "",
    var isVisible: Int = 0,
    var order: Int = 0,
    var title: String = "",
    var type: Int = 0,
    var url: String = ""
) : Parcelable
