package com.libs.jetpacks.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/9/27 5:42 PM
 */
public class CustomViewModel extends AndroidViewModel {

  String TAG = this.getClass().getSimpleName();
  private MutableLiveData<Integer> mutableLiveData;
  private Thread thread;

  public CustomViewModel(@NonNull Application application) {
    super(application);
  }


  public LiveData<Integer> getcurrData() {

    if (mutableLiveData == null) {
      mutableLiveData = new MutableLiveData<>();
    }

    return mutableLiveData;
  }

  @Override
  protected void onCleared() {
    super.onCleared();
    Log.d(TAG, "onCleared: ");
    if (thread.isAlive()){
      thread.interrupt();
    }
  }

  public int data = 1;

  public void getData() {
    thread = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 20000; i++) {
          try {
            if (i>19990){
              Thread.sleep(1000);
            }
            if (Thread.interrupted()) {
              Log.d(TAG, "run: interrupted");
              return;
            }

            data = i;
            Log.d(TAG, "run: data=" + data);
            mutableLiveData.setValue(data);
            if (mutableLiveData==null){
              getcurrData();
            }
            mutableLiveData.postValue(i);
          } catch (InterruptedException e) {
            e.printStackTrace();
            Log.d(TAG, "InterruptedException: e="+e.toString());
            return;
          }

        }
      }
    });
    thread.start();

  }

}
