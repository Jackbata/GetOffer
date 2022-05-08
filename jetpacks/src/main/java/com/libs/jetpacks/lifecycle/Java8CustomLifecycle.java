package com.libs.jetpacks.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import android.util.Log;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/9/26 5:49 PM
 */
@SuppressLint("RestrictedApi")
public class Java8CustomLifecycle implements GenericLifecycleObserver {

  String TAG = this.getClass().getSimpleName();

  @Override
  public void onStateChanged(LifecycleOwner source, Event event) {

  }

//  @Override
//  public void onCreate(LifecycleOwner owner) {
//    Log.d(TAG, "onCreate: ");
//  }
//
//  @Override
//  public void onStart(LifecycleOwner owner) {
//    Log.d(TAG, "onStart: ");
//
//  }
//
//  @Override
//  public void onResume(LifecycleOwner owner) {
//    Log.d(TAG, "onResume: ");
//  }
//
//  @Override
//  public void onPause(LifecycleOwner owner) {
//    Log.d(TAG, "onPause: ");
//  }
//
//  @Override
//  public void onStop(LifecycleOwner owner) {
//    Log.d(TAG, "onStop: ");
//  }
//
//  @Override
//  public void onDestroy(LifecycleOwner owner) {
//    Log.d(TAG, "onDestroy: ");
//  }
}
