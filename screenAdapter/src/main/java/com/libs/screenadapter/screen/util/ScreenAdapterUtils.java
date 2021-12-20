package com.libs.screenadapter.screen.util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;

/**
 * @Description:头条适配方案 https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA
 * @Author: 肖邦
 * @CreateDate: 2021/11/19 3:09 PM
 */
public class ScreenAdapterUtils {


  private static float sDensity=0;
  private static float sComponentScaleDensity=0;

  public static void setCustomDensity(Activity activity, Application application,int uiDpi){
    DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();
    DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();

    if(sDensity==0){
      sDensity=appDisplayMetrics.density;
      sComponentScaleDensity=appDisplayMetrics.scaledDensity;

      //监听字体大小变化
      application.registerComponentCallbacks(new ComponentCallbacks(){

        @Override
        public void onConfigurationChanged(@NonNull Configuration newConfig) {
          Toast.makeText(activity, "sComponentScaleDensity ="+sComponentScaleDensity, Toast.LENGTH_SHORT).show();

          if(newConfig!=null&&newConfig.fontScale>0){
             sComponentScaleDensity=application.getResources().getDisplayMetrics().scaledDensity;
             Toast.makeText(activity, "sComponentScaleDensity ="+sComponentScaleDensity, Toast.LENGTH_SHORT).show();
           }
        }
        @Override
        public void onLowMemory() {

        }
      });
    }


//    int targetDensity = appDisplayMetrics.widthPixels / uiDpi;
    int targetDensity = (int) ((float)appDisplayMetrics.widthPixels / uiDpi+0.5);
    int targetDensityDpi = (160 * targetDensity);
    float targetScaleDensity= targetDensity*(sComponentScaleDensity/sDensity);


    appDisplayMetrics.density=appDisplayMetrics.scaledDensity=targetDensity;
    appDisplayMetrics.densityDpi=targetDensityDpi;
    appDisplayMetrics.scaledDensity=targetScaleDensity;


    activityDisplayMetrics.density=activityDisplayMetrics.scaledDensity=targetDensity;
    activityDisplayMetrics.densityDpi=targetDensityDpi;
    activityDisplayMetrics.scaledDensity=targetScaleDensity;
    Toast.makeText(activity, "denscaledDensitysity ="+appDisplayMetrics.widthPixels, Toast.LENGTH_SHORT).show();

    Log.d("ScreenAdapterUtils", "setCustomDensity:heightPixels = "+ appDisplayMetrics.heightPixels+" ; widthPixels = "+ appDisplayMetrics.widthPixels+" ;targetDensity = "+targetDensity);
  }
}
