package com.up.lhm.getoffer.mvp.base;

import com.up.lhm.getoffer.mvp.observer.IObserver;
import com.up.lhm.getoffer.rxjava.RxjavaManager;
import com.up.lhm.hmtools.system.Log;

import java.lang.ref.WeakReference;

/**
 * @author lianghaimiao
 * @date 2019/3/14
 * @function
 */
public class BasePresenter<T extends IbaseView> implements IObserver {
   public T mview;
    public RxjavaManager rxjavaManager = new RxjavaManager();
    private WeakReference<T> mWeakReference;

    public BasePresenter(T view) {
        mWeakReference = new WeakReference<>(view);
        getView();
        mview.addListener(this);
    }


    @Override
    public void onCreade() {
        Log.d("mvptest", "onCreade");
    }

    @Override
    public void onResume() {
        Log.d("mvptest", "onResume");
    }

    public T getView() {
        if (mWeakReference != null) {
            mview = mWeakReference.get();
            return mview;
        }
        return null;
    }

    @Override
    public void onDestory() {
        Log.d("mvptest", "onDestory--"+this.getClass().getSimpleName());
        mview.removeListener(this);
        rxjavaManager.clear();
        if (mWeakReference != null) {
            mWeakReference.clear();
            mWeakReference = null;
            System.gc();
        }
    }
}
