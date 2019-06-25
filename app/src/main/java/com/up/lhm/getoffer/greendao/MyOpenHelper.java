package com.up.lhm.getoffer.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import com.up.lhm.getoffer.greendao.MigrationHelper.ReCreateAllTableListener;
import com.up.lhm.getoffer.greendao.bean.DaoMaster;
import com.up.lhm.getoffer.greendao.bean.ShopDao;

import org.greenrobot.greendao.database.Database;

/**
 * @author Barry
 * @date 2019-06-25
 * @function
 */

public class MyOpenHelper extends DaoMaster.OpenHelper {
    public MyOpenHelper(Context context, String name,
            CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        MigrationHelper.migrate(db, new ReCreateAllTableListener() {
            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);

            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, ShopDao.class);
    }
}
