package com.up.lhm.getoffer.dragger.bean;

import dagger.Module;
import dagger.Provides;

/**
 * @author lianghaimiao
 * @date 2019/5/12
 * @function
 */
@Module
public class SwModel {
    @Provides
    public Swadman getSW() {
        return new Swadman();
    }
}
