package com.up.lhm.getoffer;

import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;

/**
 * @author lianghaimiao
 * @date 2019/3/31
 * @function
 */

public class AntimatorsActivity extends BaseActivity {

    private TextView mTextView;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, AntimatorsActivity.class, finishSelf, args);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.animator_layout;
    }

    @Override
    public void initData() {
        mTextView = findViewById(R.id.tv);
        Animation a = new AlphaAnimation(0,100);
        Animation b = new ScaleAnimation(1,100,3,11);
        Animation c = new RotateAnimation(0,100);
        c.setInterpolator(new BounceInterpolator());

        Animation d = new TranslateAnimation(1,2,3,33);
        mTextView.startAnimation(d);
        ObjectAnimator.ofFloat(mTextView, "rotationX", 0.0F, 360.0F)
                .setDuration(500)
                .start();


        ValueAnimator animator = ValueAnimator.ofInt(0,400);
        animator.setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.setEvaluator(new IntEvaluator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                Log.d("qijian","curValue:"+curValue);
            }
        });

        animator.start();

//        mTextView.setTranslationX();
        ObjectAnimator bjectAnimator = ObjectAnimator.ofFloat(mTextView,"alpha",1,0,1);
        animator.setDuration(2000);
        animator.start();


    }



}
