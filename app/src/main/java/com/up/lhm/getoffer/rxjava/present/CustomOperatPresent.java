package com.up.lhm.getoffer.rxjava.present;


import com.up.lhm.getoffer.mvp.base.BasePresenter;
import com.up.lhm.getoffer.mvp.base.IbaseView;
import com.up.lhm.getoffer.rxjava.Contract;
import com.up.lhm.hmtools.system.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @author lianghaimiao
 * @date 2020-04-14
 * @function 自定义操作符
 */

public class CustomOperatPresent extends BasePresenter implements Contract.Rxjavaviewpresent {
    public CustomOperatPresent(IbaseView view) {
        super(view);
    }

    @Override
    public void exectObservable() {

        lift();//操作Observer
//        compose();//操作Observable
    }

    private void compose() {
        Observable.just(1,2,3,4)
                .compose(new ObservableTransformer<Integer, String>() {
                    @Override
                    public ObservableSource<String> apply(Observable<Integer> upstream) {

                        return upstream.map(new Function<Integer, String>() {
                            @Override
                            public String apply(Integer integer) throws Exception {
                                return integer+";ed";
                            }
                        });
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d("RxjavaActivity-compose", s.toString());
                    }
                });
    }

    private void lift() {

        Observable.just(1, 2, 3, 4)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {

                        return integer*10;
                    }
                })
                .lift(new ObservableOperator<String, Integer>() {
                    @Override
                    public Observer<? super Integer> apply(Observer<? super String> observer)
                            throws Exception {
                        return new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                observer.onSubscribe(d);
                            }

                            @Override
                            public void onNext(Integer value) {
                                observer.onNext(value + ":des");
                            }

                            @Override
                            public void onError(Throwable e) {
                                observer.onError(e);
                            }

                            @Override
                            public void onComplete() {
                                observer.onComplete();
                            }
                        };
                    }
                })
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s+":map3";
                    }
                })
                .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("RxjavaActivity-take", s.toString());

            }
        });


    }
}
