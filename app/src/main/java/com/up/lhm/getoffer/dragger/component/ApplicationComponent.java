package com.up.lhm.getoffer.dragger.component;

import com.up.lhm.getoffer.dragger.DraggerActivity;
import com.up.lhm.getoffer.dragger.TwoActivity;
import com.up.lhm.getoffer.dragger.bean.EngineModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function
 */

@Singleton
@Component(modules = EngineModel.class)
public interface ApplicationComponent {
    void inject(TwoActivity daggerActivity);

    void inject(DraggerActivity draggerActivity);

}
