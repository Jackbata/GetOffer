package com.up.lhm.getoffer.mvp.base;

import com.up.lhm.getoffer.mvp.observer.IObserver;
import com.up.lhm.hmtools.system.Log;

/**
 * @author lianghaimiao
 * @date 2019/3/14
 * @function
 */
  public  class BasePresenter<T extends IbaseView> implements IObserver {
    T mview;

    public BasePresenter(T view) {
        this.mview = view;
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

    @Override
    public void onDestory() {
        Log.d("mvptest", "onDestory");
        mview.removeListener(this);
    }
}
