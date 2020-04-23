package com.up.lhm.getoffer.rxjava.present;

import com.up.lhm.getoffer.mvp.base.BasePresenter;
import com.up.lhm.getoffer.mvp.base.IbaseView;
import com.up.lhm.getoffer.rxjava.Contract;
import com.up.lhm.getoffer.rxjava.Contract.Rxjavaview;
import com.up.lhm.hmtools.system.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;


/**
 * @author lianghaimiao
 * @date 2020-04-14
 * @function
 */

public class ConnectablePresent extends BasePresenter implements Contract.Rxjavaviewpresent {
    public ConnectablePresent(IbaseView view) {
        super(view);
    }

    @Override
    public void exectObservable() {
        publish();//ConnectableObservable
    }

    private void publish() {
        ConnectableObservable<Long> publish = Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(Schedulers.newThread())
                .replay();
//        Observable<Long> longObservable = publish.refCount();
        Consumer<Long> stringConsumer2 = new Consumer<Long>() {
            @Override
            public void accept(Long o) throws Exception {
                Log.d("RxjavaActivity--action2", o.toString());

            }
        };
        Consumer<Long> stringConsumer = new Consumer<Long>() {
            @Override
            public void accept(Long o) throws Exception {
                Log.d("RxjavaActivity--action1", o.toString());
                if (o == 3) {
                    Disposable subscribe = publish.subscribe(stringConsumer2);
                    rxjavaManager.add(subscribe);

                }

            }
        };

        Disposable subscribe = publish.subscribe(stringConsumer);
        Disposable connect = publish.connect();
        rxjavaManager.add(connect);
//        rxjavaManager.add(subscribe);

    }

}
