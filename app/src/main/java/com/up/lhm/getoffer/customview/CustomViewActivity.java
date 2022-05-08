package com.up.lhm.getoffer.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.customview.wiget.CircleView;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.getoffer.utils.ScreenDisplayUtil;
import com.up.lhm.hmtools.system.IntentUtil;

public class CustomViewActivity extends BaseActivity {

    private RelativeLayout root;
    private Button add;
    private Button remove;
    private LinearLayout ll_cv_bole;
    private FrameLayout cv_frist_fl;
    private LayoutTransition mTransitioner;
    private RelativeLayout fl_bole;

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
        cv_frist_fl = findViewById(R.id.cv_frist_fl);
        fl_bole = findViewById(R.id.fl_bole);
//         addCicle();
//         addChangeView();


    }



    int count=20;
    private void addChangeView() {
        mTransitioner = new LayoutTransition();
        //元素在容器中出现时所定义的动画。
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "alpha", 0, 1);
        mTransitioner.setDuration(LayoutTransition.APPEARING,2000);
        mTransitioner.setAnimator(LayoutTransition.APPEARING, animIn);

        //元素在容器中消失时所定义的动画
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "alpha", 1, 0);
        mTransitioner.setAnimator(LayoutTransition.DISAPPEARING, animOut);
        mTransitioner.setDuration(LayoutTransition.DISAPPEARING,2000);

        ll_cv_bole.setLayoutTransition(mTransitioner);




    }

    @Override
    protected void setLinister() {
        add.setOnClickListener(v -> {
//                    count++;
//
//           final Button[] button = {getButton(63)};
//
//             cv_frist_fl.addView(button[0]);
//            cv_frist_fl.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    cv_frist_fl.removeView(button[0]);
//                    button[0] =null;
//                    Button button2 = getButton(43);
//                    int childCount = ll_cv_bole.getChildCount();
//                    if (childCount>3){
//                        ll_cv_bole.removeViewAt(0);
//                    }
//                    ll_cv_bole.addView(button2);
//                }
//            },3000);

                addBole();

            }
        );
        remove.setOnClickListener(v -> {
            ll_cv_bole.removeViewAt(0);
        });
    }

    private void addBole() {
        int childCount1 = fl_bole.getChildCount();
        if (childCount1>=4){
            for (int i = childCount1; i >=5; i--) {
                View childAt = fl_bole.getChildAt(i-1);
                ObjectAnimator animIn = ObjectAnimator.ofFloat(childAt, "alpha", 1, 0);
                animIn.setDuration(1000);
                animIn.start();
                animIn.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        fl_bole.removeView(childAt);
                    }
                });
            }
            int childCount = fl_bole.getChildCount();
            if(childCount>0){
                for (int i = childCount-1; i >=0 ; i--) {
                    View childAt = fl_bole.getChildAt(i);
                    int measuredWidth1 = childAt.getMeasuredWidth();
                    int measuredWidth = measuredWidth1*(i+1);
                    ObjectAnimator animator = ObjectAnimator.ofFloat(childAt, "translationX", -measuredWidth1*i, -measuredWidth);
                    animator.setDuration(1000);
                    animator.start();
                }
            }
            fl_bole.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Button button =  new Button(CustomViewActivity.this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.height= ScreenDisplayUtil.INSTANCE.dip2px(CustomViewActivity.this,80);
                    params.width= ScreenDisplayUtil.INSTANCE.dip2px(CustomViewActivity.this,80);
                    button.setLayoutParams(params);
                    button.setText("33");
                    fl_bole.addView(button);
                    ObjectAnimator animIn = ObjectAnimator.ofFloat(button, "alpha", 0, 1);
                    animIn.setDuration(2000);
                    animIn.start();

                }
            },childCount==0?0:0);
        }else {
            int childCount = fl_bole.getChildCount();
            if(childCount>0){
                for (int i = childCount-1; i >=0 ; i--) {
                    View childAt = fl_bole.getChildAt(i);
                    int measuredWidth1 = childAt.getMeasuredWidth();
                    int measuredWidth = measuredWidth1*(i+1);
                    ObjectAnimator animator = ObjectAnimator.ofFloat(childAt, "translationX", -measuredWidth1*i, -measuredWidth);
                    animator.setDuration(1000);
                    animator.start();
                }
            }
            fl_bole.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Button button =  new Button(CustomViewActivity.this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.height= ScreenDisplayUtil.INSTANCE.dip2px(CustomViewActivity.this,80);
                    params.width= ScreenDisplayUtil.INSTANCE.dip2px(CustomViewActivity.this,80);
                    button.setLayoutParams(params);
                    button.setText("33");
                    fl_bole.addView(button);
                    ObjectAnimator animIn = ObjectAnimator.ofFloat(button, "alpha", 0, 1);
                    animIn.setDuration(2000);
                    animIn.start();

                }
            },childCount==0?0:0);
        }



    }
    private Button getButton(float size) {
        Button button =  new Button(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.height= ScreenDisplayUtil.INSTANCE.dip2px(this,size);
        params.width= ScreenDisplayUtil.INSTANCE.dip2px(this,size);
        button.setLayoutParams(params);
        button.setText(""+(count));
        return button;
    }

    private void addCicle() {
        root.addView(new CircleView(this));
    }

    @Override
    public void initData() {

    }
}
