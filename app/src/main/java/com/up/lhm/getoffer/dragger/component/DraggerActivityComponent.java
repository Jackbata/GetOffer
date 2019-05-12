package com.up.lhm.getoffer.dragger.component;

import com.up.lhm.getoffer.dragger.DraggerActivity;
import com.up.lhm.getoffer.dragger.bean.EngineModel;

import dagger.Component;

/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function
 */
@Component(modules=EngineModel.class)
public interface DraggerActivityComponent {
    void injectq(DraggerActivity draggerActivity);
}
