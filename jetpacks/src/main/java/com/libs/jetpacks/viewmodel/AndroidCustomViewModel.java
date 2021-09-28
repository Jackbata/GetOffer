package com.libs.jetpacks.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/9/27 5:42 PM
 */
public class AndroidCustomViewModel extends AndroidViewModel {

  String TAG = this.getClass().getSimpleName();

  public AndroidCustomViewModel(@NonNull Application application) {
    super(application);
  }

  @Override
  protected void onCleared() {
    super.onCleared();
    Log.d(TAG, "onCleared: ");
  }

  public int data=1;

  public void getData() {
    for (int i = 0; i < 100; i++) {
      data=i;
    }
  }
}
