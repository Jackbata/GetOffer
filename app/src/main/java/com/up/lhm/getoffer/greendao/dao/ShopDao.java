package com.up.lhm.getoffer.greendao.dao;

import com.up.lhm.getoffer.App;
import com.up.lhm.getoffer.greendao.bean.Shop;
import com.up.lhm.getoffer.greendao.bean.ShopDao.Properties;

import java.util.List;

/**
 * @author Barry
 * @date 2019-06-24
 * @function
 */

public class ShopDao implements IDao<Shop>{

    private final com.up.lhm.getoffer.greendao.bean.ShopDao mShopDao;

    public ShopDao() {
        mShopDao = App.getDaoInstant().getShopDao();
    }
    public com.up.lhm.getoffer.greendao.bean.ShopDao getDao (){
        return mShopDao;
    }
    @Override
    public void insertShop(Shop shop) {
        mShopDao.insertOrReplace(shop);
    }

    @Override
    public void deleteShop(long id) {
        mShopDao.deleteByKey(id);
    }

    @Override
    public void updateShop(Shop shop) {
        mShopDao.update(shop);
        mShopDao.deleteByKeyInTx();
    }

    @Override
    public List<Shop> queryShop() {
        return mShopDao.queryBuilder().where(Properties.Type.eq(Shop.TYPE_CART)).list();
    }

    @Override
    public List<Shop> queryAll() {
        return mShopDao.loadAll();
    }
}
