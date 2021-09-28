package com.up.lhm.getoffer.touchevent;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.up.lhm.hmtools.system.Log;

/**
 * @author lianghaimiao
 * @date 2019/4/14
 * @function
 */

@SuppressLint("AppCompatCustomView")
public class Bt extends View {
    public Bt(Context context) {
        super(context);
    }

    public Bt(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Bt(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "Bt---》dispatchTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "Bt---》dispatchTouchEvent事件分发: ACTION_MOVE");

                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "Bt---》dispatchTouchEvent事件分发: ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("事件分发", "Bt---》dispatchTouchEvent: ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                getParent().requestDisallowInterceptTouchEvent(true);
                Log.d("事件分发", "Bt---》onTouchEvent事件分发: ACTION_DOWN");
                return true;
            case MotionEvent.ACTION_MOVE:
//                                getParent().requestDisallowInterceptTouchEvent(true);

                Log.d("事件分发", "Bt---》onTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "Bt---》onTouchEvent事件分发: ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:

                //当view接收了down事件，但move事件被viewgroup拦截时，会执行该方法
                //如果viewgroup当dispatchTouchEvent只拦截move事件，那么view最终仍会响应up事件
                Log.d("事件分发", "Bt---》onTouchEvent: ACTION_CANCEL");
                break;
            default:
                break;
        }
//        return true;
        return super.onTouchEvent(event);
    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.d("cuevent","view--dispatchTouchEvent--"+getString(event.getAction()));
//        return super.dispatchTouchEvent(event);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.d("cuevent","view--onTouchEvent--"+getString(event.getAction()));
//        return true;
//    }
//
//    private String getString(int action) {
//        String result = "";
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                result = "ACTION_DOWN";
//                break;
//            case MotionEvent.ACTION_MOVE:
//                result = "ACTION_MOVE";
//                break;
//            case MotionEvent.ACTION_UP:
//                result = "ACTION_UP";
//                break;
//            default:
//                break;
//        }
//        return result;
//    }
}
