package com.up.lhm.getoffer.widget;

import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;

/**
 * @author barry
 * @date 2020/6/1
 * @function
 */

public class ImageLoader {
    private LruCache<String, Bitmap> mLruCache;

    public ImageLoader(){
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cachsize=maxMemory/8;
        mLruCache = new LruCache<String, Bitmap>(cachsize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }

          @Override
          protected void entryRemoved(boolean evicted, String key, Bitmap oldValue,
              Bitmap newValue) {
            super.entryRemoved(evicted, key, oldValue, newValue);
          }
        };
    }

     public void addBitmap(String key,Bitmap value){
        if (mLruCache.get(key)==null){
            mLruCache.put(key,value);

        }
     }

     public Bitmap getBitmap(String key){
        return mLruCache.get(key);
     }

     public void removeBitmap(String key){
       mLruCache.remove(key);
     }
}

