package com.up.lhm.getoffer.camera;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Description: 同时打开两个摄像头
 * @Author: 肖邦
 * @CreateDate: 2021/6/7 4:03 PM
 */
public class CameraActivity extends BaseActivity {

  public static void start(Context context, boolean finishSelf) {
    Bundle args = new Bundle();
    IntentUtil.redirect(context, CameraActivity.class, finishSelf, args);
  }

  SurfaceView surfaceview1, surfaceview2;
  SurfaceHolder surfaceholder1, surfaceholder2;
  String TAG = "MainActivity";
  private Camera camera1 = null, camera2;
  Camera.Parameters parameters;


  @Override
  protected int getLayoutId() {
    return R.layout.activity_camera;
  }

  @Override
  protected void initBaseView() {
    surfaceview1 = (SurfaceView) findViewById(R.id.surfaceview1);
    surfaceview2 = (SurfaceView) findViewById(R.id.surfaceview2);
    surfaceholder1 = surfaceview1.getHolder();
    surfaceholder1.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    surfaceholder1.addCallback(new surfaceholderCallbackBack());

    surfaceholder2 = surfaceview2.getHolder();
    surfaceholder2.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    surfaceholder2.addCallback(new surfaceholderCallbackFont());

  }

  /**
   * 后置摄像头回调
   */
  class surfaceholderCallbackBack implements SurfaceHolder.Callback {

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
      // 获取camera对象
      int cameraCount = Camera.getNumberOfCameras();
      if (cameraCount > 0) {
        camera1 = Camera.open(0);
        try {
          // 设置预览监听
          camera1.setPreviewDisplay(holder);
          Camera.Parameters parameters = camera1.getParameters();

          if (CameraActivity.this.getResources().getConfiguration().orientation
              != Configuration.ORIENTATION_LANDSCAPE) {
            parameters.set("orientation", "portrait");
            camera1.setDisplayOrientation(90);
            parameters.setRotation(90);
          } else {
            parameters.set("orientation", "landscape");
            camera1.setDisplayOrientation(0);
            parameters.setRotation(0);
          }
          camera1.setParameters(parameters);
          // 启动摄像头预览
          camera1.startPreview();
          System.out.println("camera.startpreview");

        } catch (IOException e) {
          e.printStackTrace();
          camera1.release();
          System.out.println("camera.release");
        }
      }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
      camera1.autoFocus(new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
          if (success) {
            initCamera();// 实现相机的参数初始化
            camera.cancelAutoFocus();// 只有加上了这一句，才会自动对焦。
          }
        }
      });

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    // 相机参数的初始化设置
    private void initCamera() {
      parameters = camera1.getParameters();
      parameters.setPictureFormat(PixelFormat.JPEG);
      parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);// 1连续对焦
      setDispaly(parameters, camera1);
      camera1.setParameters(parameters);
      camera1.startPreview();
      camera1.cancelAutoFocus();// 2如果要实现连续的自动对焦，这一句必须加上
    }

    // 控制图像的正确显示方向
    private void setDispaly(Camera.Parameters parameters, Camera camera) {
      if (Integer.parseInt(Build.VERSION.SDK) >= 8) {
        setDisplayOrientation(camera, 90);
      } else {
        parameters.setRotation(90);
      }

    }

    // 实现的图像的正确显示
    private void setDisplayOrientation(Camera camera, int i) {
      Method downPolymorphic;
      try {
        downPolymorphic = camera.getClass()
            .getMethod("setDisplayOrientation", new Class[]{int.class});
        if (downPolymorphic != null) {
          downPolymorphic.invoke(camera, new Object[]{i});
        }
      } catch (Exception e) {
        Log.e("Came_e", "图像出错");
      }
    }
  }

  class surfaceholderCallbackFont implements SurfaceHolder.Callback {

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
      // 获取camera对象
      int cameraCount = Camera.getNumberOfCameras();
      if (cameraCount == 2) {
        camera2 = Camera.open(1);
      }
      try {
        // 设置预览监听
        camera2.setPreviewDisplay(holder);
        Camera.Parameters parameters = camera2.getParameters();

        if (CameraActivity.this.getResources().getConfiguration().orientation
            != Configuration.ORIENTATION_LANDSCAPE) {
          parameters.set("orientation", "portrait");
          camera2.setDisplayOrientation(90);
          parameters.setRotation(90);
        } else {
          parameters.set("orientation", "landscape");
          camera2.setDisplayOrientation(0);
          parameters.setRotation(0);
        }
        camera2.setParameters(parameters);
        // 启动摄像头预览
        camera2.startPreview();
        System.out.println("camera.startpreview");

      } catch (IOException e) {
        e.printStackTrace();
        camera2.release();
        System.out.println("camera.release");
      }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
      camera2.autoFocus(new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
          if (success) {
            parameters = camera2.getParameters();
            parameters.setPictureFormat(PixelFormat.JPEG);
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);// 1连续对焦
            setDispaly(parameters, camera2);
            camera2.setParameters(parameters);
            camera2.startPreview();
            camera2.cancelAutoFocus();// 2如果要实现连续的自动对焦，这一句必须加上
            camera.cancelAutoFocus();// 只有加上了这一句，才会自动对焦。
          }
        }
      });

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    // 控制图像的正确显示方向
    private void setDispaly(Camera.Parameters parameters, Camera camera) {
      if (Integer.parseInt(Build.VERSION.SDK) >= 8) {
        setDisplayOrientation(camera, 90);
      } else {
        parameters.setRotation(90);
      }

    }

    // 实现的图像的正确显示
    private void setDisplayOrientation(Camera camera, int i) {
      Method downPolymorphic;
      try {
        downPolymorphic = camera.getClass()
            .getMethod("setDisplayOrientation", new Class[]{int.class});
        if (downPolymorphic != null) {
          downPolymorphic.invoke(camera, new Object[]{i});
        }
      } catch (Exception e) {
        Log.e("Came_e", "图像出错");
      }
    }
  }

  @Override
  public void initData() {

  }

  @Override
  protected void onDestroy() {
    Log.e(TAG, "onDestroy");
    super.onDestroy();
  }
}
