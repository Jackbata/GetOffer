package com.up.lhm.getoffer.rxjava.present;

import com.up.lhm.getoffer.mvp.base.BasePresenter;
import com.up.lhm.getoffer.rxjava.Contract;
import com.up.lhm.getoffer.rxjava.Contract.Rxjavaview;
import com.up.lhm.hmtools.system.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

/**
 * @author lianghaimiao
 * @date 2020-04-08
 * @function
 */

public class TransferPresent extends BasePresenter implements Contract.Rxjavaviewpresent {


    public TransferPresent(Rxjavaview view) {
        super(view);

    }
    /**
     * 转换observable操作符
     */

    @Override
    public  void exectObservable() {
        //1, 3, 4, 2
        Observable<Integer> observable = getObservable();

        buffer(observable);//返回数据指定缓存的数据集合
//        window(observable);//将指定缓存的数据封装成一个observable返回给观察者
//
//        flatmap(observable);//返回observable
//        flatmapIterable(observable);//返回可迭代集合
//        map(observable);//返回转化的数据
//
//        groupby(observable);//将数据进行分类返回
//        groupby1(observable);
//        cast(observable);//数据类型转换
//        scan(observable);//类似迭代叠加操作，下一个操作需要上一个操作的结果作为参数
    }
    private void window(Observable<Integer> observable) {
        observable.window(2,1).subscribe(new Consumer<Observable<Integer>>() {
            @Override
            public void accept(Observable<Integer> integerObservable) throws Exception {
                Log.d("RxjavaActivity-window",integerObservable.getClass().getSimpleName());
                integerObservable.subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("RxjavaActivity-window",integer.toString());

                    }
                });
            }
        });
    }

    private void scan(Observable<Integer> observable) {
        Observable.just(1,2,3,4).scan(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                return integer+integer2;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d("RxjavaActivity-scan",integer+"");

            }
        });
    }

    private void cast(Observable<Integer> observable) {

        observable.cast(Integer.class).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer aDouble) throws Exception {
                Log.d("RxjavaActivity-cast",aDouble+"");

            }
        });
    }

    private void map(Observable<Integer> observable) {
        observable.map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return integer+"aller";
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("RxjavaActivity-map",s);
            }
        });
    }

    private void groupby1(Observable<Integer> observable) {
        observable.groupBy(new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer integer) throws Exception {
                return integer > 5;
            }
        }, new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return integer+"barry";
            }
        }).subscribe(new Consumer<GroupedObservable<Boolean, String>>() {
            @Override
            public void accept(GroupedObservable<Boolean, String> booleanStringGroupedObservable)
                    throws Exception {
                booleanStringGroupedObservable.subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String integer) throws Exception {
                        Log.d("RxjavaActivity-groupBy2",
                                booleanStringGroupedObservable.getKey()+"=="+integer);
                    }
                });
            }
        });
    }

    private void groupby(Observable<Integer> observable) {
        observable.groupBy(new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer integer) throws Exception {
                return integer>4;
            }

        }).subscribe(new Consumer<GroupedObservable<Boolean, Integer>>() {
            @Override
            public void accept(GroupedObservable<Boolean, Integer> booleanIntegerGroupedObservable)
                    throws Exception {
                Log.d("RxjavaActivity-groupBy", booleanIntegerGroupedObservable.getKey()+";;;");
                booleanIntegerGroupedObservable.subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("RxjavaActivity-groupBy",
                                booleanIntegerGroupedObservable.getKey()+"=="+integer);
                    }
                });


            }
        });
    }

    private void flatmapIterable(Observable<Integer> observable) {
        observable.flatMapIterable(new Function<Integer, Iterable<String>>() {
            @Override
            public Iterable<String> apply(Integer integer) throws Exception {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(integer+"--flatmapIterable");
                strings.add("333");
                return strings;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("RxjavaActivity-flatmap",s);
            }
        });
    }

    private void flatmap(Observable<Integer> observable) {
        observable.flatMap(new Function<Integer, ObservableSource<String>>() {

            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {

                return Observable.just("flatmap:"+integer,"flatmap2:"+integer);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d("RxjavaActivity-flatmap",s);

            }
        });
    }

    private void buffer(Observable<Integer> observable) {
        observable.buffer(4,2).subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) throws Exception {
                Log.d("RxjavaActivity","buuffer"+ integers);

            }
        });

    }

    private  Observable<Integer> getObservable() {
        Observable<Integer> just = Observable.just(1, 2, 3, 4,5,6,7,8);
        return just;
    }


}
