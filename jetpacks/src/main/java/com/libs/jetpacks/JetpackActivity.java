package com.libs.jetpacks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.libs.jetpacks.databinding.bean.Books;
import com.libs.jetpacks.databinding.callback.EventCallback;
import com.libs.jetpacks.databinding.ActivityJetpackBinding;
import com.libs.jetpacks.databinding.viewmodel.DataViewmodel;
import com.libs.jetpacks.lifecycle.CustomLifecycle;
import com.libs.jetpacks.viewmodel.CustomViewModel;
import org.greenrobot.eventbus.EventBus;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/9/26 5:45 PM
 */
public class JetpackActivity extends AppCompatActivity {

  String TAG = "Java8CustomLifecycle" + this.getClass().getSimpleName();
  private ActivityJetpackBinding viewDataBinding;

  public static void start(Activity context, Boolean finshSelf) {
    Intent intent = new Intent(context, JetpackActivity.class);
    context.startActivity(intent);
    if (finshSelf) {
      context.finish();
    }
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_jetpack);
    Log.d(TAG, "onCreate: ");
    Lifecycle();
    viewmodel();
    databind();
    EventBus.getDefault().register(this);
  }

  private void databind() {
    Books books = new Books();
    books.name="Android适配UI动态设置View视图控";
    books.price=12;
    viewDataBinding.setVariable(BR.bookdata,books);
    DataViewmodel dataViewmodel = new DataViewmodel();
    viewDataBinding.setViewmodeldata(dataViewmodel);
    viewDataBinding.setEventback(new EventCallback(){
      @Override
      public void clickEvent(View view) {
        books.name="33";
        dataViewmodel.setName(""+System.currentTimeMillis());
        viewDataBinding.setVariable(BR.bookdata,books);
      }
    });
  }


  private void viewmodel() {
    CustomViewModel customViewModel = new ViewModelProvider(this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
        .get(CustomViewModel.class);
    LiveData<Integer> integerLiveData = customViewModel.getcurrData();
    integerLiveData.observe(this, new Observer<Integer>() {
      @Override
      public void onChanged(Integer integer) {
        Log.d(TAG, "CustomViewModel onChanged: integer=" + integer);
      }
    });
    customViewModel.getData();

  }

  private void Lifecycle() {
    String d="";
    d.length();
    d.charAt(1);
    getLifecycle().addObserver(new CustomLifecycle());
//    getLifecycle().addObserver(new Java8CustomLifecycle());

  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d(TAG, "onRestart: ");
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d(TAG, "onStart: ");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(TAG, "onResume: ");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(TAG, "onPause: ");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(TAG, "onStop: ");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "onDestroy: ");
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState,
      @NonNull PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
    Log.d(TAG, "onSaveInstanceState: ");
  }
}
