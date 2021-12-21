package com.libs.screenadapter.screen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.libs.screenadapter.R;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/9/26 5:45 PM
 */
@Route(path = "/screen/ArouterScreenActivity")
public class ArouterScreenActivity extends AppCompatActivity {

  String TAG = this.getClass().getSimpleName();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_arouter_screen);
    String jetdata = getIntent().getStringExtra("jetdata");
    Toast.makeText(this,jetdata,Toast.LENGTH_SHORT).show();
    findViewById(R.id.jump1).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        ARouter.getInstance().build("/jetpack/ArouterJetbackActivity")
            .withString("scree","from ArouterScreenActivity")
            .
            navigation();
      }
    });
  }
  @Override
  protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    String jetdata = getIntent().getStringExtra("jetdata");
    Toast.makeText(this,jetdata+"onNewIntent",Toast.LENGTH_SHORT).show();
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

}
