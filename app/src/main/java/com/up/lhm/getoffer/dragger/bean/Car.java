package com.up.lhm.getoffer.dragger.bean;

import com.up.lhm.getoffer.dragger.annotation.GEngine;
import com.up.lhm.hmtools.system.Log;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function
 */

public class Car {


    private Engine mEngger;

    @Inject
    public Car(@Named(true?"GEngine":"BwwEngine") Engine engger) {
        this.mEngger = engger;
    }

    public void run() {
     Log.d("c");
    }
}
