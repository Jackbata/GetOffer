package com.up.lhm.getoffer.dragger.bean;

import com.up.lhm.hmtools.system.Log;

import javax.inject.Inject;

/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function
 */

public class Worker {
    @Inject
    public Worker() {
    }

    public void work() {
        Log.d("dragger测试", "工作中...");
    }
}
