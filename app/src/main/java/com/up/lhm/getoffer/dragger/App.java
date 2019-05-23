package com.up.lhm.getoffer.dragger;

import android.app.Application;
import android.content.Context;

import com.up.lhm.getoffer.BuildConfig;
import com.up.lhm.getoffer.dragger.component.ApplicationComponent;
import com.up.lhm.getoffer.dragger.component.DaggerApplicationComponent;


/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function
 */

public class App extends Application {

    private ApplicationComponent mActivityComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mActivityComponent = DaggerApplicationComponent
                .builder()
                .build();

    }

    public static App getComponent(Context context) {
        return (App) context.getApplicationContext();
    }

    ApplicationComponent getActivityComponen() {
        return mActivityComponent;
    }

}
