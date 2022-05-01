package com.up.lhm.getoffer.apm.apmutil;

import android.util.Log;
import android.view.Choreographer;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2022/4/7 7:55 PM
 */
public class FPSUtil implements Choreographer.FrameCallback {

  long lastframeTimeNanos = 0;

  @Override
  public void doFrame(long frameTimeNanos) {
    //60帧/s
    if (lastframeTimeNanos == 0) {
      lastframeTimeNanos = frameTimeNanos;
      Choreographer.getInstance().postFrameCallback(this);
      return;
    }
    long frame = (frameTimeNanos - lastframeTimeNanos) / 1000000l;
    if (frame > 16) {
      int v = (int) ((frame - 16.6) / 16.6 + 0.5);
      Log.d("FPSUtil", "doFrame:  " + frame + "当前页面掉帧 " + v + "帧");
    }
    lastframeTimeNanos = frameTimeNanos;
    Choreographer.getInstance().postFrameCallback(this);
  }

  public static void init() {
    Choreographer.getInstance().postFrameCallback(new FPSUtil());
  }
}
