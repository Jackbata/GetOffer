package com.up.lhm.getoffer.aidl;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import com.up.lhm.getoffer.MainActivity;
import com.up.lhm.getoffer.greendao.GreendaoActivity;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/10/11 4:15 PM
 */
public class StartDestoryService extends Service {
String TAG=this.getClass().getSimpleName();
  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    Log.d(TAG, "onBind: ");
    return new MyBinder();
  }

  @Override
  public boolean onUnbind(Intent intent) {
    Log.d(TAG, "onUnbind: ");
    return super.onUnbind(intent);
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.d(TAG, "onStartCommand: ");
    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public ComponentName startForegroundService(Intent service) {
    Log.d(TAG, "startForegroundService: ");
    return super.startForegroundService(service);
  }

  @Override
  public void onCreate() {
    Log.d(TAG, "onCreate: ");
    super.onCreate();
  }


  @Override
  public void onDestroy() {
    Log.d(TAG, "onDestroy: ");
    super.onDestroy();
  }
  class MyBinder extends Binder {

    public void callMethod1() {
      Log.d(TAG, "callMethod1: ");
      Intent intent = new Intent(getApplication(), MainActivity.class);
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      getApplication().startActivity(intent);
    }

    public void callMethod2() {
      Log.d(TAG, "callMethod2: ");

    }
  }

}
