package com.up.lhm.getoffer;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
    public void onCreate() {
        super.onCreate();

        getComponet();
        initGreenDao();
        Fresco.initialize(getApplicationContext());

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
}
