package com.up.lhm.getoffer.customview.wiget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.up.lhm.getoffer.utils.ScreenDisplayUtil;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2022/5/15 3:39 PM
 */
public class CustomRelative extends RelativeLayout {

  public CustomRelative(Context context) {
    super(context);
  }

  public CustomRelative(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public CustomRelative(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public void  addView(Context context, int size, int Scaleize, String tex, int maxSize,
      Runnable runnable){
    removeEnoughView(context,maxSize);
    mvoeView(context,size,Scaleize);
    showAddView(context,size,tex,runnable);
  }

  private void mvoeView(Context context,int size,int Scaleize) {
    int childCount = getChildCount();
    if (childCount > 0) {
      for (int i =0; i<childCount; i++) {
        View childAt = getChildAt(i);
        float x = childAt.getX();
        float tr =x- ScreenDisplayUtil.INSTANCE.dip2px(context,Scaleize);
        ValueAnimator translationX = new ValueAnimator().ofFloat(x, tr);
        translationX.addUpdateListener(new AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator animation) {
            childAt.setX((Float) animation.getAnimatedValue());
          }
        });

        if (i==childCount - 1){
          float y1 = childAt.getY();
          float y2 = (float) (y1+ScreenDisplayUtil.INSTANCE.dip2px(context, (size-Scaleize)/2));

          ValueAnimator translationY = new ValueAnimator().ofFloat(y1, y2);
          translationY.addUpdateListener(new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
              childAt.setY((Float) animation.getAnimatedValue());
            }
          });
          ValueAnimator valueAnimator = new ValueAnimator().ofInt(
              ScreenDisplayUtil.INSTANCE.dip2px(context,size),
              ScreenDisplayUtil.INSTANCE.dip2px(context,Scaleize));
          valueAnimator.setDuration(1000);
          valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
              ViewGroup.LayoutParams layoutParams =  childAt.getLayoutParams();
              layoutParams.width= (int) animation.getAnimatedValue();
              layoutParams.height= (int) animation.getAnimatedValue();
              childAt.requestLayout();
            }
          });
          AnimatorSet animatorSet = new AnimatorSet();
          animatorSet.playTogether(valueAnimator,translationX,translationY);
          animatorSet.setDuration(1000);
          animatorSet.start();
        }else {
          translationX.start();
        }

      }
    }
  }

  private void removeEnoughView(Context context,int maxSize) {
    int childCount1 = getChildCount();
    if (childCount1>=maxSize){
      for (int i = childCount1; i >=maxSize; i--) {
        View childAt = getChildAt(0);
        ObjectAnimator animIn = ObjectAnimator.ofFloat(childAt, "alpha", 1, 0);
        animIn.setDuration(1000);

        animIn.addListener(new AnimatorListenerAdapter() {
          @Override
          public void onAnimationEnd(Animator animation) {
            removeView(getChildAt(0));
          }
        });
        animIn.start();
      }
    }
  }

  private void showAddView(Context context,int size,String tex, Runnable runnable) {
    View view=getButton(context,size,tex);
    ObjectAnimator animIn = ObjectAnimator.ofFloat(view, "alpha", 0, 1);
    animIn.setDuration(2000);
    animIn.start();
    animIn.addListener(new AnimatorListenerAdapter(){
      @Override
      public void onAnimationEnd(Animator animation) {
         postDelayed(new Runnable() {
                       @Override
                       public void run() {
                         runnable.run();
                       }
                     }
             , 3000);
      }
    });
  }

  public View  getButton(Context context,int size,String text){
    Button button = new Button(context);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.WRAP_CONTENT,
        ViewGroup.LayoutParams.WRAP_CONTENT);
    params.height = ScreenDisplayUtil.INSTANCE.dip2px(context, size);
    params.width = ScreenDisplayUtil.INSTANCE.dip2px(context, size);
    button.setLayoutParams(params);
    button.setText(text);
    addView(button);
    return button;
  }
}
