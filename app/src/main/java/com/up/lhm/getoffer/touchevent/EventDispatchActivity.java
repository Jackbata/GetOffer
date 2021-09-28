package com.up.lhm.getoffer.touchevent;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

import com.up.lhm.getoffer.R;
import com.up.lhm.hmtools.system.Log;

/**
 * @author lianghaimiao
 * @date 2019/3/1
 * @function
 */

public class EventDispatchActivity extends AppCompatActivity {

    private Bt mBtn;
    private RelativeLayout mRl;
    private Customview mView;
    private CustomViewGroup mViewGroup;
    private Cd mCd;


    public static void start(Context context, boolean finishSelf) {

        Intent intent = new Intent();
        intent.setAction("android.intent.action.Atext");
        PackageManager packageManager = context.getPackageManager();
        ResolveInfo resolveInfo = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        context.startActivity(intent);
//        Bundle args = new Bundle();
//        IntentUtil.redirect(context, EventDispatchActivity.class, finishSelf, args);
    }
    @Override
    protected void onCreate(@Nullable   Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
        mRl = findViewById(R.id.rl);
        mBtn = findViewById(R.id.btn1);
        mBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCd.setX(111);
                mCd.requestLayout();
            }
        });
        mViewGroup = findViewById(R.id.cg);
        mView = findViewById(R.id.cv);

        mCd = findViewById(R.id.cd);
//        mCd.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.d("事件分发", "ViewGroup---》setOnTouchListener: onTouch");
//                return true;
//            }
//        });
//        mBtn.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.d("事件分发", "view---》setOnTouchListener: onTouch");
//
//                return true;
//            }
//        });
//        mBtn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("事件分发", "view---》setOnClickListener: onClick");
//
//            }
//        });
        //        mCd.setOntouListener(new OntouListener() {
//            @Override
//            public void setclick(String string) {
//                Log.d("cuevent","响应了事件"+string);
//            }
//        });
    }

    /**
     * 1.dispatchTouchEvent返回的是onTouchEvent是否消费的结果
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "activity---》dispatchTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "activity---》dispatchTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "activity---》dispatchTouchEvent事件分发: ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("事件分发", "activity---》dispatchTouchEvent: ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("事件分发", "activity---》onTouchEvent事件分发: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("事件分发", "activity---》onTouchEvent事件分发: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("事件分发", "activity---》onTouchEvent事件分发: ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d("事件分发", "activity---》onTouchEvent: ACTION_CANCEL");
                break;
            default:
                break;
        }

        return super.onTouchEvent(event);
    }


    private void viewGroupTouch() {

    }

    private void viewTouch() {
//        mBtn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        mBtn.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        Log.d("事件分发", "mBtnview事件分发: ACTION_DOWN");
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        Log.d("事件分发", "mBtnview事件分发: ACTION_MOVE");
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        Log.d("事件分发", "mBtnview事件分发: ACTION_UP");
//                        break;
//                }
//                return true;
//            }
//        });
//
//        mView.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        Log.d("事件分发", "view事件分发: ACTION_DOWN");
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        Log.d("事件分发", "view事件分发: ACTION_MOVE");
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        Log.d("事件分发", "view事件分发: ACTION_UP");
//                        break;
//                }
//
//                return true;
//            }
//        });
        mView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("事件分发", "点击了按钮");
            }
        });
    }
}
