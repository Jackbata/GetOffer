package com.up.lhm.getoffer.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.up.lhm.hmtools.system.Log;

/**
 * @author lianghaimiao
 * @date 2019/4/14
 * @function
 */

public class Cd2 extends RelativeLayout {
    public Cd2(Context context) {
        super(context);
    }

    public Cd2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Cd2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "Cd2---》dispatchTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "Cd2---》dispatchTouchEvent事件分发: ACTION_MOVE");
               break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "Cd2---》dispatchTouchEvent事件分发: ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("事件分发", "Cd2---》dispatchTouchEvent: ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "Cd2---》onInterceptTouchEvent事件分发: ACTION_DOWN");
               break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "Cd2---》onInterceptTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "Cd2---》onInterceptTouchEvent事件分发: ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("事件分发", "Cd2---》onInterceptTouchEvent事件分发: ACTION_CANCEL");
                break;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "Cd2---》onTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "Cd2---》onTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "Cd2---》onTouchEvent事件分发: ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("事件分发", "Cd2---》onTouchEvent: ACTION_CANCEL");
                break;
        }
        return true;
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.d("cuevent", "viewgroup--onInterceptTouchEvent--" + getString(ev.getAction()));
//        if (mOntouListener != null) {
//            mOntouListener.setclick(getString(ev.getAction()));
//        }
//        return super.onInterceptTouchEvent(ev);
//    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.d("cuevent", "viewgroup--dispatchTouchEvent--" + getString(ev.getAction()));
//
//        return super.dispatchTouchEvent(ev);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.d("cuevent", "viewgroup--onTouchEvent--" + getString(event.getAction()));
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
//
//    public OntouListener mOntouListener;
//
//    public void setOntouListener(OntouListener ontouListener) {
//        mOntouListener = ontouListener;
//    }
}