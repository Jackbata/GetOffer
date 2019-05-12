package com.up.lhm.getoffer.mvp.base;

import com.up.lhm.getoffer.mvp.observer.IObserver;
import com.up.lhm.getoffer.mvp.observer.IObverListener;

/**
 * @author lianghaimiao
 * @date 2019/4/20
 * @function
 */

public interface IbaseView<T extends IObserver> extends IObverListener<T> {
}
