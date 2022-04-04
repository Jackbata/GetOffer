package com.up.lhm.getoffer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;

import com.libs.jetpacks.JetpackActivity;
import com.libs.mathlib.off.XIaoHingShu;
import com.libs.screenadapter.screen.util.ScreenAdapterUtils;
import com.up.lhm.annotationlibs.BindVieww;
import com.up.lhm.getoffer.MyAdapter.OnItemClickListener;
import com.up.lhm.getoffer.aidl.AIDLActivity;
import com.up.lhm.getoffer.apm.ApmActivity;
import com.up.lhm.getoffer.arouter.ArouterMainActivity;
import com.up.lhm.getoffer.bean.DataList;
import com.up.lhm.getoffer.camera.CameraActivity;
import com.up.lhm.getoffer.camera.CameraActivity2;
import com.up.lhm.getoffer.dragger.DraggerActivity;
import com.up.lhm.getoffer.glide.GlideActivity;
import com.up.lhm.getoffer.greendao.GreendaoActivity;
import com.up.lhm.getoffer.hashmap.HashMapActivity;
import com.up.lhm.getoffer.hotfix.HotFixUtil;
import com.up.lhm.getoffer.image.ImageActivity;
import com.up.lhm.getoffer.ipc.IpcActivity;
import com.up.lhm.getoffer.jsbridge.JSActivity;
import com.up.lhm.getoffer.mvp.activity.ViewActivity;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.getoffer.net.okhttp.OkhttpActivity;
import com.up.lhm.getoffer.notes.GetUrl;
import com.up.lhm.getoffer.notes.TestAnnotate;
import com.up.lhm.getoffer.recycle.RecyclerviewActivity;
import com.up.lhm.getoffer.rxjava.RxjavaActivity;
import com.up.lhm.getoffer.screen.ScreenAdapterActivity;
import com.up.lhm.getoffer.systemview.SystemViewActivity;
import com.up.lhm.getoffer.threadpool.ThreadPoolsActivity;
import com.up.lhm.getoffer.touchevent.EventDispatchActivity;
import com.up.lhm.getoffer.utils.ScreenDisplayUtil;
import com.up.lhm.getoffer.viewscoller.ViewScollerActivity;
import com.up.lhm.getoffer.webview.WebviewActivity;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author lianghaimiao
 */
public class MainActivity extends BaseActivity {

  /**
   * 编译时注解控件
   */
  @BindVieww(value = R.id.tvtext)
  TextView tvtext;


  /**
   * 技能点列表
   */
  private RecyclerView mRv;
  /**
   * 技能点列表
   */
  private List<DataList> mList = new ArrayList<>();
  private String[] mDataList = {"事件分发机制", "HashMap原理", "线程池", "动画原理", "view滑动", "MVP", "Arouter",
      "dragger2",
      "greendao", "jsbridage", "图片框架", "rxjava", "okhttp", "跳转第三方应用", "webview", "图片适配",
      "AIDL", "系统组件", "recycleview", "APM性能监测", "前后摄像头", "前后摄像头2", "jetpack","屏幕适配","可继续填充"};
  private MyAdapter mAdapter;


  @Override
  protected int getLayoutId() {
//    ScreenAdapterUtils.setCustomDensity(this,getApplication(),1366);

    return R.layout.activity_main;
  }

  @TestAnnotate(index = 1, name = "李四")
  @GetUrl(url = "https://www.baidu.com/s?i")
  private void initView() {
    mRv = findViewById(R.id.rv);
   TextView  tvtext1 = findViewById(R.id.tvtext);
//    tvtext1.setOnClickListener();
//    tvtext1.setOnLongClickListener();
//    tvtext1.getParent().requestDisallowInterceptTouchEvent();
    tvtext1.post(new Runnable() {
      @Override
      public void run() {
        Log.d("BaseActivity", "run: main");
      }
    });
    Thread bay = new Thread(new Runnable() {
      @Override
      public void run() {
        boolean baseActivity = tvtext1.post(new Runnable() {
          @Override
          public void run() {
            android.util.Log.d("BaseActivity", "run: chilid11");
          }
        });
        android.util.Log.d("BaseActivity", "run: baseActivityqq  = "+baseActivity);

      }
    });
    bay.start();
  }
  @Override
  protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    Log.d("MainActivity", "onNewIntent: ");
  }

  @Override
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
  }

  @Override
  public void initData() {
    initView();
    Log.d("MainActivity", "initData: ");

    initrvdata();

    HotFixUtil.hotFix(getApplicationContext(),"hot.dex");

    initRv();
    setListener();
    int displayHeight = ScreenDisplayUtil.INSTANCE.getDisplayHeight(this);
    int getDisplayWidth = ScreenDisplayUtil.INSTANCE.getDisplayWidth(this);
    Log.d("MainActivity","displayHeight= "+displayHeight+",getDisplayWidth"+getDisplayWidth);
 }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState,
      @NonNull PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
  }

  private void initrvdata() {
    for (int i = 0; i < mDataList.length; i++) {
      DataList dataList = new DataList();
      dataList.index = i;
      dataList.name = mDataList[i];
      mList.add(dataList);
      String a = "e";
      a.hashCode();
      a.equals("d");
    }
  }

  @SuppressLint("WrongConstant")
  private void initRv() {
    GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
    linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
    mRv.setLayoutManager(linearLayoutManager);
    mAdapter = new MyAdapter(mList);
    mRv.setAdapter(mAdapter);
    mRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//    tvtext.getViewTreeObserver().addOnDrawListener(null);
  }

  private void setListener() {
    mAdapter.setmOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(int position) {
        switch (position) {
          case 0:
            EventDispatchActivity.start(MainActivity.this, false);
            break;
          case 1:
            HashMapActivity.start(MainActivity.this, false);
            break;
          case 2:
            ThreadPoolsActivity.start(MainActivity.this, false);
            break;
          case 3:
            AntimatorsActivity.start(MainActivity.this, false);
            break;
          case 4:
            ViewScollerActivity.start(MainActivity.this, false);
            break;
          case 5:
            ViewActivity.start(MainActivity.this, false);
            break;
          case 6:
            ArouterMainActivity.start(MainActivity.this, false);
            break;
          case 7:
            DraggerActivity.start(MainActivity.this, false);
            break;
          case 8:
            GreendaoActivity.start(MainActivity.this, false);
            break;
          case 9:
            JSActivity.start(MainActivity.this, false);
            break;
          case 10:
            GlideActivity.start(MainActivity.this, false);
            break;
          case 11:
            RxjavaActivity.start(MainActivity.this, false);
            break;
          case 12:
            OkhttpActivity.start(MainActivity.this, false);
            break;
          case 13:
            IpcActivity.start(MainActivity.this, false);
            break;
          case 14:
            WebviewActivity.start(MainActivity.this, false);
            break;
          case 15:
            ImageActivity.start(MainActivity.this, false);
            break;
          case 16:
            AIDLActivity.start(MainActivity.this, false);
            break;
          case 17:
            SystemViewActivity.start(MainActivity.this, false);
            break;
          case 18:
            RecyclerviewActivity.start(MainActivity.this, false);
            break;
          case 19:
            ApmActivity.start(MainActivity.this, false);
            break;
          case 20:
            CameraActivity.start(MainActivity.this, false);
            break;
          case 21:
            CameraActivity2.start(MainActivity.this, false);
            break;
          case 22:
            JetpackActivity.start(MainActivity.this, false);
//            new XIaoHingShu().testxhs();
            break;
          case 23:
            ScreenAdapterActivity.start(MainActivity.this, false);
          default:
            break;
        }
      }
    });


  }

  public String geturl() {

    return "";
  }

  public String dev() {
    //dev第一次提交远程分支
    //dev第2次提交远程分支
    //dev第3次提交远程分支
    // dev第4次提交远程分支
    // dev第5次提交远程分支
    // dev第6次提交远程分支
    // dev第7次提交远程分支
    // dev第8次提交远程分支
    // dev第9次提交远程分支

    return "master";
  }

  public String featch() {
    //featch第一次提交远程分支
    //featch第er次提交远程分支
    //featch第3次提交远程分支
    //featch第4次提交远程分支
    //featch第5次提交远程分支
    //featch第6次提交远程分支
    //featch第7次提交远程分支
    //featch第8次提交远程分支
    return "";
  }
  public void fix() {
    System.out.println("错误代码");
  }
}
