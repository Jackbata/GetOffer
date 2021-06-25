package com.up.lhm.getoffer.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.view.MotionEvent
import android.view.View
import android.view.View.OnSystemUiVisibilityChangeListener
import android.view.ViewConfiguration


object ScreenDisplayUtil {
    fun dip2px(context: Context, dipValue: Float): Int {
        val m = context.resources.displayMetrics.density
        return (dipValue * m + 0.5f).toInt()
    }

    fun px2dip(context: Context, pxValue: Float): Int {
        val m = context.resources.displayMetrics.density
        return (pxValue / m + 0.5f).toInt()
    }

    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }

    /**
     * 长的为宽度 <功能详细描述>
     *
     * @param context
     * @return
     * @see [类、类.方法、类.成员]
    </功能详细描述> */
    fun screenWidthPx(context: Context): Int {
        val widthPx = context.resources.displayMetrics.widthPixels
        val heightPx = context.resources.displayMetrics.heightPixels
        return if (widthPx > heightPx) widthPx else heightPx
    }

    /**
     * 小的为高度
     *
     * @param context
     * @return
     */
    fun screenHeightPx(context: Context): Int {
        val widthPx = context.resources.displayMetrics.widthPixels
        val heightPx = context.resources.displayMetrics.heightPixels
        return if (widthPx > heightPx) heightPx else widthPx
    }

    /**
     * 宽度
     */
    fun realScreenWidthPx(context: Context): Int {
        return context.resources.displayMetrics.widthPixels
    }

    /**
     * 高度
     */
    fun realScreenHeightPx(context: Context): Int {
        return context.resources.displayMetrics.heightPixels
    }

    fun sp2px(spValue: Float, fontScale: Float): Int {
        return (spValue * fontScale + 0.5f).toInt()
    }

    /**
     * 获取屏幕宽度
     *
     * @param activity Activity
     * @return Width
     * @see [类、类.方法、类.成员]
     */
    fun getDisplayWidth(activity: Activity): Int {
        return activity.windowManager.defaultDisplay.width
    }

    /**
     * 获取屏幕高度
     *
     * @param activity Activity
     * @return Width
     * @see [类、类.方法、类.成员]
     */
    fun getDisplayHeight(activity: Activity): Int {
        return activity.windowManager.defaultDisplay.height
    }

    /**
     * 获取虚拟按键栏高度
     * @param context
     * @return
     */
    fun getNavigationBarHeight(context: Context): Int {
        var result = 0
        if (hasNavBar(context)) {
            val res = context.resources
            val resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = res.getDimensionPixelSize(resourceId)
            }
        }
        return result
    }

    /**
     * 检查是否存在虚拟按键栏
     * @param context
     * @return
     */
    private fun hasNavBar(context: Context): Boolean {
        val res = context.resources
        val resourceId = res.getIdentifier("config_showNavigationBar", "bool", "android")
        return if (resourceId != 0) {
            var hasNav = res.getBoolean(resourceId)
            // check override flag
            val sNavBarOverride = navBarOverride
            if ("1" == sNavBarOverride) {
                hasNav = false
            } else if ("0" == sNavBarOverride) {
                hasNav = true
            }
            hasNav
        } else { // fallback
            !ViewConfiguration.get(context).hasPermanentMenuKey()
        }
    }

    /**
     * 判断虚拟按键栏是否重写
     * @return
     */
    private val navBarOverride: String?
        get() {
            var sNavBarOverride: String? = null
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                try {
                    val c = Class.forName("android.os.SystemProperties")
                    val m = c.getDeclaredMethod("get", String::class.java)
                    m.isAccessible = true
                    sNavBarOverride = m.invoke(null, "qemu.hw.mainkeys") as String
                } catch (e: Throwable) {
                }
            }
            return sNavBarOverride
        }

    /**
     * 获取状态栏高度
     * @param context
     * @return
     */
    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        try {
            val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return result
    }

    /**
     * 隐藏导航栏
     */
    @SuppressLint("ObsoleteSdkInt")
    fun hideNavigateBar(view: View?) {
        if (view == null) {
            return
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            view.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            view.setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener {
                var uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or  //布局位于状态栏下方
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or  //全屏
                        View.SYSTEM_UI_FLAG_FULLSCREEN or  //隐藏导航栏
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                uiOptions = if (Build.VERSION.SDK_INT >= 19) {
                    uiOptions or 0x00001000
                } else {
                    uiOptions or View.SYSTEM_UI_FLAG_LOW_PROFILE
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    view.systemUiVisibility = uiOptions
                }
            })
        }
    }

    fun setStatusBarLightMode(view: View?, lightMode: Boolean) {
        if (view != null) {
            var uiVisibility = view.systemUiVisibility
            if (Build.VERSION.SDK_INT >= 23) {
                if (lightMode) {
                    uiVisibility = uiVisibility or 8192
                } else {
                    uiVisibility -= 8192
                }
                view.systemUiVisibility = uiVisibility
            }
        }
    }

    /**
     * 获取视频播放器高度
     * @param isExpand 是否
     */
    fun getVideoPlayerHeight(mContext: Context, isExpand: Boolean = false): Int {
        val mPlayerWidth: Int
        if (isExpand) {
            mPlayerWidth = getDisplayWidth(mContext as Activity)
        } else {
            mPlayerWidth = getDisplayWidth(mContext as Activity) - dip2px(mContext, 216f)
        }
        return mPlayerWidth * 9 / 16
    }

    /**
     * 判断点击事件是否在指定view的内部
     *
     * @param event
     * @param view
     * @return
     */
    fun isInView(event: MotionEvent?, view: View?): Boolean {
        if (event == null || view == null) {
            return false
        }
        val view_data = IntArray(2)
        view.getLocationInWindow(view_data)
        return event.x > view_data[0] && event.x < view_data[0] + view.width && event.y > view_data[1] && event.y < view_data[1] + view.height
    }


    /**
     * 隐藏虚拟按键，并且全屏
     */
    fun hideBottomUIMenu(mContext: Context) { //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            val v = (mContext as Activity).window.decorView
            v.systemUiVisibility = View.GONE
        } else if (Build.VERSION.SDK_INT >= 19) { //for new api versions.
            val decorView = (mContext as Activity).window.decorView
            val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN)
            decorView.systemUiVisibility = uiOptions
        }
    }

    /**
     * 判断当前设备是手机还是平板，代码来自 Google I/O App for Android
     * @param context
     * @return 平板返回 true，手机返回 false
     */
    fun isPad(context: Context): Boolean {
        return ((context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
    }

    //半角转换为全角
    fun toDBC(input: String): String{
        val c = input.toCharArray()
        for (i in c.indices) {
            if (c[i].toInt() == 12288) {
                c[i] = 32.toChar()
                continue
            }
            if (c[i].toInt() in 65281..65374) c[i] = (c[i] - 65248)
        }
        return String(c)
    }

}