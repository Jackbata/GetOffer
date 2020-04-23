package com.up.lhm.getoffer.rxjava;

import com.up.lhm.getoffer.mvp.base.IbaseView;

/**
 * @author lianghaimiao
 * @date 2020-04-08
 * @function
 */

public interface Contract {
    interface Rxjavaview extends IbaseView {
    }

    interface Rxjavaviewpresent {
        void exectObservable();
    }
}
