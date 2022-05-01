package com.up.lhm.getoffer

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.animation.*
import android.widget.Toast
import com.up.lhm.getoffer.mvp.base.BaseActivity
import com.up.lhm.hmtools.system.IntentUtil
import com.up.lhm.hmtools.system.ToastUtils
import kotlinx.android.synthetic.main.animator_layout.*

/**
 * @author lianghaimiao
 * @date 2019/3/31
 * @function
 */
class AntimatorsActivity : BaseActivity() {
    companion object {
        @JvmStatic
        fun start(context: Context?, finishSelf: Boolean) {
            val args = Bundle()
            IntentUtil.redirect(context, AntimatorsActivity::class.java, finishSelf, args)
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }
    override fun getLayoutId(): Int {
        return R.layout.animator_layout
    }

    override fun initData() {
    }

    override fun setLinister() {
        bt_red.setOnClickListener {
            startRed()
        }
    }

    private fun startRed() {
                iv_red.visibility=View.VISIBLE

        val rotationY = ObjectAnimator.ofFloat(iv_red, "rotationY", -90f,0f)

        val objectAnimator1: ObjectAnimator = ObjectAnimator.ofFloat(iv_red, "scaleX", 1f, 1.1f,1f)
        objectAnimator1.interpolator= BounceInterpolator()

        val objectAnimator2: ObjectAnimator = ObjectAnimator.ofFloat(iv_red1, "scaleX", 1.3f, 1f,1.2f,1f)
        val objectAnimator3: ObjectAnimator = ObjectAnimator.ofFloat(iv_red1, "scaleY", 1.3f, 1f,1.2f,1f)
        objectAnimator3.duration=500
        objectAnimator2.duration=500
//        objectAnimator1.duration=200
//        val objectAnimator2: ObjectAnimator = ObjectAnimator.ofFloat(iv_red, "scale", 0f, 1f)
//        iv_red.pivotX=1f
        val set = AnimatorSet()
        set.play(rotationY).with(objectAnimator2).with(objectAnimator3)
        set.start()

//        ObjectAnimator animator=ObjectAnimator.ofFloat(iv_red,"rotationX",0.0F,180.0F,00.0F);//图片默认X轴旋转
//           animator.setDuration(2000);//旋转动画持续时间为2000毫秒
//        animator.start();//开始执行动画(图片X轴旋转)

//        val scaleAnimation = ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1f)
//        scaleAnimation.interpolator= BounceInterpolator()
//
//        val mShowAction = TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
//                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
//                1.0f, Animation.RELATIVE_TO_SELF, 0.0f)
//
//        val animationSet = AnimationSet(true)
//        animationSet.duration=1000
//        animationSet.addAnimation(scaleAnimation)
//        animationSet.addAnimation(mShowAction)
//        iv_red.visibility=View.VISIBLE
//        iv_red?.startAnimation(animationSet)

    }


}