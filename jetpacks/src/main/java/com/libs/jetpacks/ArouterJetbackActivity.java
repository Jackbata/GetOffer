package com.libs.jetpacks;

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

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/9/26 5:45 PM
 */
@Route(path = "/jetpack/ArouterJetbackActivity")
public class ArouterJetbackActivity extends AppCompatActivity {

  String TAG = this.getClass().getSimpleName();


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_arouter_jetpack);
    String scree = getIntent().getStringExtra("scree");
    Toast.makeText(this,scree,Toast.LENGTH_SHORT).show();

    findViewById(R.id.jump1_jetpack).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        ARouter.getInstance().build("/screen/ArouterScreenActivity")
            .withString("jetdata","from ArouterJetbackActivity")
            .navigation();
      }
    });
  }

  @Override
  protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    String scree = getIntent().getStringExtra("scree");
    Toast.makeText(this,scree+"onNewIntent",Toast.LENGTH_SHORT).show();
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
