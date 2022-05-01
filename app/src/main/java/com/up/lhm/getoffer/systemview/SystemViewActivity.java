package com.up.lhm.getoffer.systemview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;

public class SystemViewActivity extends BaseActivity {

  public static void start(Context context, boolean finishSelf) {
    Bundle args = new Bundle();
    IntentUtil.redirect(context, SystemViewActivity.class, finishSelf, args);
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_system_view;
  }

  @Override
  protected void initBaseView() {
    findViewById(R.id.textview).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });
    findViewById(R.id.dialog_bt).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        new Thread(new Runnable() {
          @Override
          public void run() {
            Looper.prepare();
            showDialog();
            Looper.loop();

          }
        }).start();

      }
    });

  }

  @Override
  public void initData() {

  }

  private AlertDialog alertDialog = null;

  public void showDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setIcon(R.mipmap.ic_launcher)
        .setMessage("潇湘剑雨")
        .setTitle("这个是标题")
        .setView(R.layout.dialog_view)
        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            alertDialog.dismiss();
          }
        })
        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            alertDialog.dismiss();
          }
        });
    alertDialog = builder.create();
    alertDialog.show();

  }

}
