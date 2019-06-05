package com.up.lhm.getoffer.touchevent;

import android.annotation.SuppressLint;
import android.content.Context;
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
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("cuevent","view--dispatchTouchEvent--"+getString(event.getAction()));
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("cuevent","view--onTouchEvent--"+getString(event.getAction()));
        return true;
    }

    private String getString(int action) {
        String result = "";
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                result = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                result = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                result = "ACTION_UP";
                break;
            default:
                break;
        }
        return result;
    }
}
