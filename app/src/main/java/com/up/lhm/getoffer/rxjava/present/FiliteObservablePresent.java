package com.up.lhm.getoffer.rxjava.present;


import com.up.lhm.getoffer.mvp.base.BasePresenter;
import com.up.lhm.getoffer.mvp.base.IbaseView;
import com.up.lhm.getoffer.rxjava.Contract;
import com.up.lhm.hmtools.system.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;


/**
 * @author lianghaimiao
 * @date 2020-04-08
 * @function 过滤操作符
 */

public class FiliteObservablePresent extends BasePresenter implements Contract.Rxjavaviewpresent {


    public FiliteObservablePresent(IbaseView view) {
        super(view);
    }

    @Override
    public void exectObservable() {

        //1.根据条件过滤
        //        filter();//根据条件过滤数据
//        distinct();//过滤重复数据
//        distinctUtilchanged();//只过滤连续且重复的数据

        //2.根据事件发生时间过滤
//          throttleWithTimeout();//过滤所有不大于指定发送时间的数据
//          debounce();//依据时间过滤时，和throttleWithTimeout相同；依据函数过滤时，

        //        sample();//获取指定时间段内发送的最后一个数据
//        throttleFirst();//获取指定时间内，发生的第一个事件

//         3.根据事件发生顺序过滤
//        elementAt();//只获取指定维护的数据
//        first();//获取第一个数据

//        take();//获取指定数量的数据
//        skip();//跳过指定数量的数字


    }

    private void throttleFirst() {
        Disposable subscribe = Observable.interval(200, TimeUnit.MILLISECONDS)
                .throttleFirst(1000, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d("RxjavaActivity-take", aLong.toString());

                    }
                });
        rxjavaManager.add(subscribe);
    }

    private void sample() {
        Disposable subscribe = Observable.interval(200, TimeUnit.MILLISECONDS)
                .sample(1000, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d("RxjavaActivity-take", aLong.toString());

                    }
                });
        rxjavaManager.add(subscribe);
    }

    private void skip() {
        Observable.just(1,2,3,4,5,6,7)
                .skip(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("RxjavaActivity-take", integer.toString());

                    }
                });
    }

    private void take() {
        Observable.just(1,2,3,4,5,6,7)
                .take(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("RxjavaActivity-take", integer.toString());

                    }
                });
    }

    private void first() {
        Observable.just(1,2,3,5,21,24)
                .last(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("RxjavaActivity-first", integer.toString());
                        Log.d("RxjavaActivity-first",   Observable.just(1,2,3,5,21,25)
                                .blockingLast()
                                .toString());

                    }
                });
    }

    private void filter() {
        Observable.just(0,1,2,3,4,5,6)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer>3;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("RxjavaActivity-filter", integer.toString());

                    }
                });

    }

    private void elementAt() {
        Observable.just(1,2,3,4,5,2,2,1)
                .elementAt(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("RxjavaActivity-elementAt", integer.toString());

                    }
                });
    }

    private void distinctUtilchanged() {
        Observable.just(1,2,3,2,2,2,3,5,6,5)
                .distinctUntilChanged()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("RxjavaActivity-distinctUtilchanged", integer.toString());

                    }
                });
    }

    private void distinct() {
        Observable.just(1,2,3,4,1,2,3,4)
                .distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("RxjavaActivity-distinct", integer.toString());
                    }
                });
    }

    private void debounce() {

        Observable.just(1,2,3,4,5,6)
                .debounce(
                new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer)
                            throws Exception {

                        return Observable.just(integer+"dd");
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d("RxjavaActivity-debounce", integer.toString());
            }
        });




//        Disposable subscribe = Observable.interval(1, TimeUnit.SECONDS)
//                .debounce(new Function<Long, ObservableSource<Long>>() {
//                    @Override
//                    public ObservableSource<Long> apply(Long aLong) throws Exception {
//                        return Observable.timer(aLong%2*2,TimeUnit.SECONDS);
//                    }
//                })
//                .subscribe(aLong -> Log.d("RxjavaActivity-debounce", aLong.toString()));
//        rxjavaManager.add(subscribe);
    }

    private void throttleWithTimeout() {
        Disposable subscribe = Observable
                .interval(2, TimeUnit.SECONDS)
                .throttleWithTimeout(1, TimeUnit.SECONDS)
                .subscribe(aLong -> Log.d("RxjavaActivity-throttleWithTimeout", aLong.toString()));
        rxjavaManager.add(subscribe);
    }
}
