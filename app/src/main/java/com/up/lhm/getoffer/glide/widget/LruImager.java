package com.up.lhm.getoffer.glide.widget;


import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * @author Barry
 * @date 2019-11-11
 * @describe
 */

public class LruImager {


    private final LruCache<String, Bitmap> mLruImager;

    public LruImager() {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        //单位 kb
        int cachesize = maxMemory / 8;
        mLruImager = new LruCache<String, Bitmap>(cachesize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }

    public void addBitmap(String key, Bitmap bitmap) {
        if (mLruImager != null) {
            mLruImager.put(key, bitmap);
        }
    }

    public Bitmap getBitmap(String key) {
        if (mLruImager != null) {
            return mLruImager.get(key);
        }
        return null;
    }


    public Bitmap removeBitmap(String key) {

        if (mLruImager != null) {
            return mLruImager.remove(key);
        }
        return null;
    }
}
