package com.up.lhm.getoffer.glide;

import com.up.lhm.getoffer.mvp.activity.Contract.Xview;
import com.up.lhm.getoffer.mvp.base.BasePresenter;
import com.up.lhm.getoffer.mvp.observer.IObserver;

/**
 * @author lianghaimiao
 * @date 2019/3/14
 * @function
 */

public class GlidePresent extends BasePresenter<Xview> implements GlideContract.Xpresent {


    public GlidePresent(GlideActivity activity) {
        super(activity);

    }

    @Override
    public void setdata() {

    }

    @Override
    public void addListener(IObserver listener) {

    }

    @Override
    public void removeListener(IObserver listener) {

    }
}
