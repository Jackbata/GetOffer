package com.up.lhm.getoffer.mvp.base;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.observer.IObserver;
import com.up.lhm.getoffer.mvp.observer.IObverListener;
import com.up.lhm.getoffer.mvp.observer.ObserverMan;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author lianghaimiao
 * @date 2019/3/14
 * @function
 */

public abstract class BaseActivity extends AppCompatActivity implements IObverListener {
    @BindView(R.id.toolbar)
   public Toolbar mToolbar;
    @BindView(R.id.base_content)
    FrameLayout mBaseContent;
    private ObserverMan mObserverMan;
    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

         mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        FrameLayout content = findViewById(R.id.base_content);
        View inflate = LayoutInflater.from(this).inflate(getLayoutId(), null, true);
        content.addView(inflate);
        mBind = ButterKnife.bind(this);

        /**
         *注册
         */
        mObserverMan = new ObserverMan();
//      EventBus.getDefault().register(this);
        initBaseView();
        initData();
        mObserverMan.onCreade();
        mToolbar.setTitle(initTitle(""));
        setLinister();
        customTitle();
    }

    protected void initBaseView() {}

    protected  void customTitle(){};

    protected  void setLinister(){};

    protected  String initTitle(String title){

        return TextUtils.isEmpty(title)?getClass().getSimpleName():title;
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
      System.runFinalization();
      System.gc();
//      EventBus.getDefault().unregister(this);
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
