package com.up.lhm.getoffer.touchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.up.lhm.hmtools.system.Log;

/**
 * @author lianghaimiao
 * @date 2019/3/1
 * @function
 */

public class Customview extends View {
    public Customview(Context context) {
        super(context);
    }

    public Customview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Customview(Context context,  @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "view---》dispatchTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "view---》dispatchTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "view---》dispatchTouchEvent事件分发: ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "view---》onTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "view---》onTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "view---》onTouchEvent事件分发: ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }
}
