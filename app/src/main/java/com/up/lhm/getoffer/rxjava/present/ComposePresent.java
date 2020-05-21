package com.up.lhm.getoffer.rxjava.present;

import com.up.lhm.getoffer.mvp.base.BasePresenter;
import com.up.lhm.getoffer.rxjava.Contract;
import com.up.lhm.getoffer.rxjava.Contract.Rxjavaview;
import com.up.lhm.hmtools.system.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;

/**
 * @author lianghaimiao
 * @date 2020-04-13
 * @function
 */

public class ComposePresent extends BasePresenter<Rxjavaview> implements Contract.Rxjavaviewpresent{
    public ComposePresent(Rxjavaview view) {
        super(view);
    }

    @Override
    public void exectObservable() {
//        combinelatest();//合并多个事件
//        join();//合并组合 可多次
        zip();//合并组合observable

//        merge();//合并
//        mergedelayerror();//合并出错处理
//        startwith();//在事件钱添加数据
    }

    private void zip() {
        Observable.zip(Observable.interval(1, TimeUnit.SECONDS).take(3), Observable.interval(1,
                TimeUnit.SECONDS).take(4),
                Observable.interval(1, TimeUnit.SECONDS).take(5),
                new Function3<Long, Long, Long, String>() {
                    @Override
                    public String apply(Long aLong, Long aLong2, Long aLong3) throws Exception {
                        return aLong+"="+aLong2+"="+aLong3;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d("RxjavaActivity-zip", s.toString());

                    }
                });

    }

    private void startwith() {
        Observable.just(1,2,3,4).startWith(Observable.just(1,1,2)).subscribe(
                new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("RxjavaActivity-startWith", integer.toString());

                    }
                });
    }

    private void mergedelayerror() {
        Observable.mergeDelayError(Observable.error(new Throwable("dfs")),Observable.just("a","s",
                "d","f"))
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String value) {
                        Log.d("RxjavaActivity-mergeDelayError", ";"+value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("RxjavaActivity-mergeDelayError", ";"+e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void merge() {
        Observable.merge(Observable.just(1,2,4,5),Observable.just(3,1,5,6))
                .subscribe(integer -> Log.d("RxjavaActivity-merge", ";"+integer.toString()));
    }

    private void join() {
        Observable.just(1,2,3,4,6).join(Observable.just("a", "d", "c"),
                new Function<Integer, Observable<Long>>() {
                    @Override
                    public Observable<Long> apply(Integer integer)
                            throws Exception {
                        Log.d("RxjavaActivity-1", ";"+integer.toString());

                        return Observable.timer(1, TimeUnit.SECONDS);
                    }
                }, new Function<String, Observable<Long>>() {
                    @Override
                    public Observable<Long> apply(String s) throws Exception {
                        Log.d("RxjavaActivity-2", ";"+s);

                        return  Observable.timer(1, TimeUnit.SECONDS);
                    }
                }, new BiFunction<Integer, String, String>() {
                    @Override
                    public String apply(Integer integer, String s) throws Exception {
                        Log.d("RxjavaActivity-3", integer.toString()+";"+s);

                        return integer+";"+s;
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("RxjavaActivity-join", s.toString());

            }
        });
    }

    private void combinelatest() {

        Disposable subscribe = Observable.combineLatest(getObserval(1), getObserval(3),
                new BiFunction<Integer, Integer, String>() {
                    @Override
                    public String apply(Integer aLong, Integer aLong2) throws Exception {
                        return "1--"+aLong+";3--"+aLong2;
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("RxjavaActivity-take", s.toString());

            }
        });
        rxjavaManager.add(subscribe);
    }

    private Observable<Integer> getObserval(int i) {
      return  Observable.just(1,2,3,4)
              .map(new Function<Integer, Integer>() {
                  @Override
                  public Integer apply(Integer integer) throws Exception {
                      Log.d("RxjavaActivity-just","i==:"+i+";"+ integer.toString());

                      return integer*i;
                  }
              });

    }
}
