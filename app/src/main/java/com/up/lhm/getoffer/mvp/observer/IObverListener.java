package com.up.lhm.getoffer.mvp.observer;

/**
 * @author lianghaimiao
 * @date 2019/4/20
 * @function
 */

public interface IObverListener<T extends IObserver> {
    void addListener(T listener);
    void removeListener(T listener);
}
