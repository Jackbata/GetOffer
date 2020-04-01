package com.up.lhm.getoffer.mvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.observer.IObserver;
import com.up.lhm.getoffer.mvp.observer.IObverListener;
import com.up.lhm.getoffer.mvp.observer.ObserverMan;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lianghaimiao
 * @date 2019/3/14
 * @function
 */

 public  abstract class BaseActivity extends Activity implements IObverListener {
    private ObserverMan mObserverMan;
    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }});
            FrameLayout content = findViewById(R.id.base_content);
            View inflate = LayoutInflater.from(this).inflate(getLayoutId(),null,true);
        content.addView(inflate);
        mBind = ButterKnife.bind(this);

        /**
         *注册
         */
        mObserverMan = new ObserverMan();
        initData();
        mObserverMan.onCreade();
    }

    protected abstract int getLayoutId();

    public abstract void initData();

    @Override
    protected void onResume() {
        super.onResume();
        mObserverMan.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mObserverMan.onDestory();
    }

    @Override
    public void addListener(IObserver listener) {
        mObserverMan.addListener(listener);
    }

    @Override
    public void removeListener(IObserver listener) {
        mObserverMan.removeListener(listener);
    }
}
