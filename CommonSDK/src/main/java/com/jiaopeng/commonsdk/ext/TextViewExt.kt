package com.jiaopeng.commonsdk.ext

import android.graphics.drawable.Drawable
import android.text.Html
import android.text.TextUtils
import android.widget.TextView
import com.blankj.utilcode.util.ResourceUtils
import com.blankj.utilcode.util.SizeUtils

/**
 * 描述：TextView扩展函数
 *
 * @author JiaoPeng by 4/30/21
 */
/**
 * 设置 TextView 值
 */
fun TextView?.text(charSequence: CharSequence?) {
    this?.text = charSequence ?: ""
}

/**
 * 获取 TextView 值
 */
fun TextView?.textString() = this?.text.toString().trim()

/**
 * 设置 TextView 显示Html样式
 */
fun TextView?.text4Html(string: CharSequence?) {
    this?.text = Html.fromHtml(string.toString())
}

/**
 * 设置TextView的值并去除设置的drawables
 */
fun TextView.text2ClearDrawables(text: String, color: Int, padding: Float = 20F) {
    this.minHeight = 0
    this.minWidth = 0
    this.minimumHeight = 0
    this.minimumWidth = 0
    this.text = text
    this.setTextColor(color)
    this.setCompoundDrawables(null, null, null, null)
    this.setPadding(SizeUtils.dp2px(padding), 0, SizeUtils.dp2px(padding), 0)
}

/**
 * 设置TextView的左侧图标,不包含文字
 */
fun TextView.text2StartImg(
    res: Int,
    bounds: Float = 16F,
    padding: Float = 20F
) {
    this.text = ""
    val drawable = ResourceUtils.getDrawable(res)
    drawable.setBounds(0, 0, SizeUtils.dp2px(bounds), SizeUtils.dp2px(bounds))
    this.setPadding(SizeUtils.dp2px(padding), 0, SizeUtils.dp2px(padding), 0)
    this.setCompoundDrawables(drawable, null, null, null)
}

/**
 * 设置TextView的左侧图标,包含文字
 */
fun TextView.text2StartImgAndText(
    res: Int,
    text: String,
    padding: Float = 20F,
    bounds: Float = 16F,
    drawablePadding: Float = 8F
) {
    this.text = text
    val drawable = ResourceUtils.getDrawable(res)
    drawable.setBounds(0, 0, SizeUtils.dp2px(bounds), SizeUtils.dp2px(bounds))
    this.setPadding(SizeUtils.dp2px(padding), 0, SizeUtils.dp2px(padding), 0)
    this.setCompoundDrawables(drawable, null, null, null)
    this.compoundDrawablePadding = SizeUtils.dp2px(drawablePadding)
}


/**
 * 设置TextView的左侧图标,包含文字
 */
fun TextView.text2StartImgAndText(
    drawable: Drawable,
    text: String,
    padding: Float = 20F,
    bounds: Float = 16F,
    drawablePadding: Float = 8F
) {
    this.text = text
    drawable.setBounds(0, 0, SizeUtils.dp2px(bounds), SizeUtils.dp2px(bounds))
    this.setPadding(SizeUtils.dp2px(padding), 0, SizeUtils.dp2px(padding), 0)
    this.setCompoundDrawables(drawable, null, null, null)
    this.compoundDrawablePadding = SizeUtils.dp2px(drawablePadding)
}

/**
 * 设置TextView的右侧图标,不包含文字
 */
fun TextView.text2EndImg(
    res: Int,
    bounds: Float = 16F,
    padding: Float = 20F
) {
    this.text = ""
    val drawable = ResourceUtils.getDrawable(res)
    drawable.setBounds(0, 0, SizeUtils.dp2px(bounds), SizeUtils.dp2px(bounds))
    this.setPadding(SizeUtils.dp2px(padding), 0, SizeUtils.dp2px(padding), 0)
    this.setCompoundDrawables(null, null, drawable, null)
}

/**
 * 设置TextView的右侧图标,包含文字
 */
fun TextView.text2EndImgAndText(
    res: Int,
    text: String,
    padding: Float = 20F,
    bounds: Float = 16F,
    drawablePadding: Float = 8F
) {
    this.text = text
    val drawable = ResourceUtils.getDrawable(res)
    drawable.setBounds(0, 0, SizeUtils.dp2px(bounds), SizeUtils.dp2px(bounds))
    this.setPadding(SizeUtils.dp2px(padding), 0, SizeUtils.dp2px(padding), 0)
    this.setCompoundDrawables(null, null, drawable, null)
    this.compoundDrawablePadding = SizeUtils.dp2px(drawablePadding)
}

/**
 * 设置TextView的右侧图标,包含文字
 */
fun TextView.text2EndImgAndText(
    drawable: Drawable,
    text: String,
    padding: Float = 20F,
    bounds: Float = 16F,
    drawablePadding: Float = 8F
) {
    this.text = text
    drawable.setBounds(0, 0, SizeUtils.dp2px(bounds), SizeUtils.dp2px(bounds))
    this.setPadding(SizeUtils.dp2px(padding), 0, SizeUtils.dp2px(padding), 0)
    this.setCompoundDrawables(null, null, drawable, null)
    this.compoundDrawablePadding = SizeUtils.dp2px(drawablePadding)
}

/**
 * 判断TextView的值是否为空
 */
fun TextView?.textIsEmpty() = TextUtils.isEmpty(this?.text)

/**
 * 判断TextView的值是否为空，并做对应的操作
 */
fun TextView?.textIsEmpty(
    notEmptyAction: ((String) -> Unit)? = null,
    EmptyAction: (() -> Unit)? = null
) {
    if (TextUtils.isEmpty(this?.text)) {
        EmptyAction?.invoke()
    } else {
        notEmptyAction?.invoke(this?.text.toString())
    }
}


















