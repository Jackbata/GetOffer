package com.up.lhm.getoffer.greendao.dao;

import java.util.List;

/**
 * @author Barry
 * @date 2019-06-24
 * @function
 */

public interface IDao<T> {

    /**
     * 添加数据，如果有重复则覆盖
     */
     void insertShop(T t);

    /**
     * 删除数据
     */
     void deleteShop(long id);

    /**
     * 更新数据
     */
     void updateShop(T t);

    /**
     * 查询Type为1的所有数据
     */
     List<T> queryShop();

    /**
     * 查询所有数据
     */
     List<T> queryAll();
}
