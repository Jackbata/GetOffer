package com.up.lhm.getoffer.mvp.observer;


import java.io.Serializable;

/**
 * @author lianghaimiao
 * @date 2019/4/20
 * @function
 */

public interface IObserver extends Serializable {
    void onCreade();
    void onResume();
    void onDestory();
}
