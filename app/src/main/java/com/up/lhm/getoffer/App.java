package com.up.lhm.getoffer;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.up.lhm.getoffer.dragger.component.ApplicationComponent;
import com.up.lhm.getoffer.dragger.component.DaggerApplicationComponent;
import com.up.lhm.getoffer.greendao.MyOpenHelper;
import com.up.lhm.getoffer.greendao.bean.DaoMaster;
import com.up.lhm.getoffer.greendao.bean.DaoSession;


/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function
 */

public class App extends Application {

    private ApplicationComponent mActivityComponent;
    private static DaoSession mDaoSession;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getComponet();
        initGreenDao();
        Fresco.initialize(getApplicationContext());
       new Application.ActivityLifecycleCallbacks(){

           @Override
           public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

           }

           @Override
           public void onActivityStarted(Activity activity) {

           }

           @Override
           public void onActivityResumed(Activity activity) {

           }

           @Override
           public void onActivityPaused(Activity activity) {

           }

           @Override
           public void onActivityStopped(Activity activity) {

           }

           @Override
           public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

           }

           @Override
           public void onActivityDestroyed(Activity activity) {

           }
       };
    }

    private void getComponet() {
        mActivityComponent = DaggerApplicationComponent
                .builder()
                .build();
    }


    public static App getComponent(Context context) {
        return (App) context.getApplicationContext();
    }

    public ApplicationComponent getActivityComponen() {
        return mActivityComponent;
    }

    private void initGreenDao() {
        MyOpenHelper helper = new MyOpenHelper(this, "shop.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return mDaoSession;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
