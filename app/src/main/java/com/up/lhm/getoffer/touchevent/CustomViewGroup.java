package com.up.lhm.getoffer.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

import com.up.lhm.hmtools.system.Log;

/**
 * @author lianghaimiao
 * @date 2019/3/1
 * @function 自定义的viewGroup
 */

public class CustomViewGroup extends ViewGroup {


    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "ViewGroup---》dispatchTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "ViewGroup---》dispatchTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "ViewGroup---》dispatchTouchEvent事件分发: ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "ViewGroup---》onInterceptTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "ViewGroup---》onInterceptTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "ViewGroup---》onInterceptTouchEvent事件分发: ACTION_UP");
                break;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "ViewGroup---》onTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "ViewGroup---》onTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "ViewGroup---》onTouchEvent事件分发: ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }

}
