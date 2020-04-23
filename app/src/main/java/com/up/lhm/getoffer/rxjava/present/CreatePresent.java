package com.up.lhm.getoffer.rxjava.present;

import com.up.lhm.getoffer.mvp.base.BasePresenter;
import com.up.lhm.getoffer.rxjava.Contract.Rxjavaview;
import com.up.lhm.hmtools.system.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author lianghaimiao
 * @date 2020-04-08
 * @function
 */

public class CreatePresent extends BasePresenter<Rxjavaview>  {

    public CreatePresent(Rxjavaview view) {
        super(view);

    }
    /**
     * 1. 创建操作符
     */
    public void createObservable() {
//        unsafeCreate();
                 create(); //创建被观察者，自己调用观察者的方法
//        defer();//每次订阅都会创建新的被观察者对象
//        just();//将传入的数据发送给观察者
//        from();//将传入的集合中的元素一个一个的，发送给观察者
//        repeat();//将数据重复多少次发送给观察者
//        interval();//间隔多久发送数字，该数字从0开始递增
        timer();//间隔多久发送数字0
//        range();//发送从start开始的count个数，strat+count-1
//        empty();
    }
    private void empty() {
        Observable.never().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                rxjavaManager.add(d);

            }

            @Override
            public void onNext(Object value) {
                Log.d("RxjavaActivity-onNext", value.toString());

            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxjavaActivity-onComplete", e.getMessage().toString());

            }

            @Override
            public void onComplete() {
                Log.d("RxjavaActivity-onComplete", "onComplete");

            }
        });

    }

    private void unsafeCreate() {

        Observable.unsafeCreate(new ObservableSource<String>() {
            @Override
            public void subscribe(Observer<? super String> observer) {
                observer.onNext("1");
                observer.onNext("4");
                observer.onNext("3");
                observer.onComplete();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Log.d("RxjavaActivity-onNext", value.toString());

            }

            @Override
            public void onError(Throwable e) {j

            }

            @Override
            public void onComplete() {
                Log.d("RxjavaActivity-onComplete", "onComplete");

            }
        });

    }

    private void range() {
        Observable.range(1, 4).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d("RxjavaActivity-range", integer.toString());

            }
        });
    }

    private void create() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; i < 10; i++) {
                    e.onNext(i);
                    if (i == 8) {
                        e.onComplete();
                    }
                }
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                rxjavaManager.add(d);
            }

            @Override
            public void onNext(Integer value) {
                Log.d("RxjavaActivity-onNext", value.toString());

            }

            @Override
            public void onError(Throwable e) {
                Log.d("RxjavaActivity-onError", e.getMessage().toString());

            }

            @Override
            public void onComplete() {
                Log.d("RxjavaActivity-onComplete", "onComplete");

            }
        });
    }

    private void timer() {
        Disposable subscribe = Observable.timer(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d("RxjavaActivity-timer", aLong.toString());

                    }
                });
        rxjavaManager.add(subscribe);
    }

    private void repeat() {
        Observable.just(1, 2, 3, 4).repeat(3).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d("RxjavaActivity-repeat", integer.toString());

            }
        });
    }

    private void interval() {
        Disposable rxjavaActivity = Observable.interval(1, TimeUnit.SECONDS)
                //在那个线程观察
                .observeOn(AndroidSchedulers.mainThread())
                //事件在哪个线程执行
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d("RxjavaActivity-interval", aLong.toString());
                    }
                });
        rxjavaManager.add(rxjavaActivity);
    }

    private void from() {
        Integer[] ar = {1, 3, 4, 2};
        Observable.fromArray(ar).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d("RxjavaActivity", integer.toString());

            }
        });
    }

    private void defer() {

        Observable.defer(new Callable<ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> call() throws Exception {
                return Observable.just(1, 2, 32, 4);
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d("RxjavaActivity", integer.toString());
            }
        });
    }

    private void just() {
        Observable.just(1, 2, 32, 4).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d("RxjavaActivity", integer.toString());
            }
        });
    }

}
