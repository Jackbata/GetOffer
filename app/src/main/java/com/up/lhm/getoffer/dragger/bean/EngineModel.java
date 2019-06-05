package com.up.lhm.getoffer.dragger.bean;


import com.up.lhm.getoffer.dragger.annotation.GEngine;


import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function
 */
@Module
public class EngineModel {

    //    @GEngine
    @Provides
    @Named("GEngine")//设置每个待注入实例的关键词
    public Engine getEngineGson() {
        return new GsonEngine();
    }

//    @com.up.lhm.getoffer.dragger.annotation.BwwEngine
    @Provides
    @Named("BwwEngine")
    public Engine getEngineBww() {
        return new BwwEngine();
    }

}
