package com.up.lhm.getoffer.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.customview.wiget.CircleView;
import com.up.lhm.getoffer.customview.wiget.CustomRelative;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.getoffer.utils.ScreenDisplayUtil;
import com.up.lhm.hmtools.system.IntentUtil;
import com.up.lhm.hmtools.system.Log;

public class CustomViewActivity extends BaseActivity {

    private RelativeLayout root;
    private Button add;
    private Button remove;
    private LinearLayout ll_cv_bole;
    private LinearLayout ll_cv_bole2;
    private FrameLayout cv_frist_fl;
    private LayoutTransition mTransitioner;
    private RelativeLayout fl_bole;
    private CustomRelative fl_bole_cus;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, CustomViewActivity.class, finishSelf, args);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom_view;
    }

    @Override
    protected void initBaseView() {
        root = findViewById(R.id.custom_view_fl_root);
        add = findViewById(R.id.ll_cv_bt_add);
        remove = findViewById(R.id.ll_cv_bt_remove);
        ll_cv_bole = findViewById(R.id.ll_cv_bole);
        ll_cv_bole2 = findViewById(R.id.ll_cv_bole2);
        cv_frist_fl = findViewById(R.id.cv_frist_fl);
        fl_bole = findViewById(R.id.fl_bole);
        fl_bole_cus = findViewById(R.id.fl_bole_cus);
//         addCicle();
//         addChangeView(ll_cv_bole);
//         addChangeView2(ll_cv_bole2);


    }



    int count=20;
    private void addChangeView(ViewGroup view) {
        mTransitioner = new LayoutTransition();
        //元素在容器中出现时所定义的动画。
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "alpha", 0, 1);
        mTransitioner.setDuration(LayoutTransition.APPEARING,2000);
        mTransitioner.setAnimator(LayoutTransition.APPEARING, animIn);

        //元素在容器中消失时所定义的动画

        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "alpha", 1, 0);
        mTransitioner.setAnimator(LayoutTransition.DISAPPEARING, animOut);
        mTransitioner.setDuration(LayoutTransition.DISAPPEARING,2000);

        view.setLayoutTransition(mTransitioner);

    }
    int invout=33;
    @Override
    protected void setLinister() {
        add.setOnClickListener(v -> {
                fl_bole_cus.addView(this,80,60,(invout++)+"",5,new Runnable(){

                    @Override
                    public void run() {
                        add.performClick();
                    }
                });
//                bole1();
//                 scalview();

            }
        );
        remove.setOnClickListener(v -> {
            ll_cv_bole.removeViewAt(0);
        });
    }

    private void scalview() {
        if (ll_cv_bole2.getChildCount() > 0) {
            View childAt = ll_cv_bole2.getChildAt(ll_cv_bole2.getChildCount()-1);
            ValueAnimator valueAnimator = new ValueAnimator().ofInt(
                ScreenDisplayUtil.INSTANCE.dip2px(CustomViewActivity.this,80),
                ScreenDisplayUtil.INSTANCE.dip2px(CustomViewActivity.this,40));
            valueAnimator.setDuration(1000);
            valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    LayoutParams layoutParams = childAt.getLayoutParams();
                    layoutParams.width= (int) animation.getAnimatedValue();
                    layoutParams.height= (int) animation.getAnimatedValue();
                    childAt.requestLayout();
                }
            });
            valueAnimator.start();
        }
            Button button2 = getButton(80);
            ll_cv_bole2.addView(button2);
            int childCount = ll_cv_bole2.getChildCount();
            if (childCount>=4){
                ll_cv_bole2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ll_cv_bole2.removeViewAt(3);

                    }
                }, 1000);

            }
        }


    private void bole1() {
        count++;

        final Button[] button = {getButton(63)};

        cv_frist_fl.addView(button[0]);
        cv_frist_fl.postDelayed(new Runnable() {
            @Override
            public void run() {
                cv_frist_fl.removeView(button[0]);
                button[0] =null;
                Button button2 = getButton(43);
                int childCount = ll_cv_bole.getChildCount();
                if (childCount>3){
                    ll_cv_bole.removeViewAt(0);
                }
                ll_cv_bole.addView(button2);
                ObjectAnimator animIn = ObjectAnimator.ofFloat(button2, "alpha", 0, 1);
                animIn.setDuration(2000);
                animIn.start();
            }
        },3000);
    }


    private Button getButton(float size) {
        Button button =  new Button(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height= ScreenDisplayUtil.INSTANCE.dip2px(this,size);
        params.width= ScreenDisplayUtil.INSTANCE.dip2px(this,size);
        button.setLayoutParams(params);
        button.setText(""+(count++));
        return button;
    }

    private void addCicle() {
        root.addView(new CircleView(this));
    }

    @Override
    public void initData() {

    }
}
