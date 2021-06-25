package com.up.lhm.getoffer.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import kotlin.math.abs


/**
 * 过宽则两边裁剪
 * 过高则裁剪上边
 */
class ClipBitmapUtils {

    private var screenWidth = 0
    private var screenHeight = 0
    private var displayWidth = 0
    private var displayHeight = 0
    var resultBtm : Bitmap? =null

    fun getBgDrable(context:Context,drawableId: Int): Drawable? {
        val  resultBtm  = getBitmap(context,drawableId)
       return BitmapDrawable(resultBtm)
    }
    /**
     * 获取适配后的Drawable
     */
    fun getBitmap(context:Context,drawableId: Int): Bitmap? {
        var oldBitmap: Bitmap? =null
        var scaleBitmap: Bitmap? =null
        try {
            //获取屏幕宽高(不包括虚拟导航栏)
            screenWidth = ScreenDisplayUtil.screenWidthPx(context)
            screenHeight = ScreenDisplayUtil.screenHeightPx(context)
            displayWidth = screenWidth
            displayHeight = screenHeight

            var oldBitmap = BitmapFactory.decodeResource(context.resources, drawableId)

            val bitmapWidth = oldBitmap.width
            val bitmapHeight = oldBitmap.height

            if (bitmapWidth<displayWidth||bitmapHeight<screenHeight){
                //如果图片不能填充屏幕,则做等比例放大
                displayWidth = screenHeight * bitmapWidth / bitmapHeight
                displayHeight = screenWidth * bitmapHeight / bitmapWidth
                if (displayWidth >= screenWidth) {
                    displayHeight = screenHeight
                } else {
                    displayWidth = screenWidth
                }
                 scaleBitmap = Bitmap.createScaledBitmap(oldBitmap, displayWidth, displayHeight, true)
            }else{
                //如果图片本身很大，则直接进行裁剪
                displayWidth=bitmapWidth
                displayHeight=bitmapHeight
                scaleBitmap=oldBitmap
            }

            val diffWidth: Int = abs(n = screenWidth - displayWidth)
            val diffHeight: Int = abs(n = screenHeight - displayHeight)
             resultBtm = Bitmap.createBitmap(scaleBitmap, diffWidth / 2, diffHeight, screenWidth, screenHeight)

            return resultBtm

        }catch (e:Exception){
            e.printStackTrace()
        }finally {
            oldBitmap?.recycle()
            scaleBitmap?.recycle()
            oldBitmap=null
            scaleBitmap=null
            System.gc()
        }
        return null
    }

    /**
     * 回收bitmap
     */
    fun release(){
        resultBtm?.recycle()
        resultBtm=null
        System.gc()
    }
}