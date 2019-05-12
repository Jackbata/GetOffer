package com.up.lhm.getoffer.dragger.bean;

import android.view.ViewDebug.ExportedProperty;

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

    @Provides
    @GEngine
    public Engine getEngineGson() {
        return new GsonEngine();
    }

    @Provides
    @com.up.lhm.getoffer.dragger.annotation.BwwEngine
    public Engine getEngineBww() {
        return new BwwEngine();
    }
}
