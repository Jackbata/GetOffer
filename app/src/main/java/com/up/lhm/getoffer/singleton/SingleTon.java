package com.up.lhm.getoffer.singleton;

/**
 * @author lianghaimiao
 * @date 2019/3/7
 * @function
 */

public class SingleTon {


    private SingleTon() { }
    //静态内部类
//    public static SingleTon getInstance() {
//        return Inner.SINGLETON;
//    }
//
//    private static class Inner {
//        private static final SingleTon SINGLETON = new SingleTon();
//    }


    private static volatile SingleTon single;

    public static SingleTon getInstance() {
        if (single == null) {
            synchronized (SingleTon.class) {
                if (single == null) {
                    single = new SingleTon();
                }
            }
        }
        return single;
    }
}
