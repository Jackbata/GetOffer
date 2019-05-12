package com.up.lhm.getoffer.dragger.component;

import com.up.lhm.getoffer.dragger.bean.SwModel;
import com.up.lhm.getoffer.dragger.bean.Swadman;

import dagger.Component;
import dagger.Provides;

/**
 * @author lianghaimiao
 * @date 2019/5/12
 * @function
 */
@Component(modules = SwModel.class)
public interface SwadmanComponent {
    Swadman getSwadman();
}
