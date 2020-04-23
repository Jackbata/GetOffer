package com.up.lhm.getoffer.rxjava;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author lianghaimiao
 * @date 2020-04-07
 * @function 当页面销毁时，统一取消rxjava订阅
 */

public class RxjavaManager {


    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void add(Disposable d) {
        compositeDisposable.add(d);
    }

    public void clear() {
        if(!compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }
}
