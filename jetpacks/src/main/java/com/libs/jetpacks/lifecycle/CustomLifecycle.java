package com.libs.jetpacks.lifecycle;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/9/26 5:49 PM
 */
public class CustomLifecycle implements LifecycleObserver {

  String TAG = this.getClass().getSimpleName();

  @OnLifecycleEvent(Event.ON_CREATE)
  public void initData() {
    Log.d(TAG, "ON_CREATE");
  }

  @OnLifecycleEvent(Event.ON_DESTROY)
  public void initDESTROY() {
    Log.d(TAG, "ON_DESTROY");
  }

  @OnLifecycleEvent(Event.ON_RESUME)
  public void initRESUME() {
    Log.d(TAG, "ON_RESUME");
  }

  @OnLifecycleEvent(Event.ON_ANY)
  public void initANY() {
    Log.d(TAG, "ON_ANY");
  }

}

