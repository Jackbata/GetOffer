package com.up.lhm.getoffer.net.okhttp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import com.up.lhm.getoffer.mvp.base.BasePresenter;
import com.up.lhm.getoffer.net.url.BaseUrl;
import com.up.lhm.hmtools.system.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;


/**
 * @author lianghaimiao
 * @date 2020-04-23
 * @function
 */

public class OkhttpPresent extends BasePresenter<OkhttpActivity> implements Contract.OkhttpPresent {

  private final OkHttpClient mOkHttpClient;
  private android.os.Handler mHandler = new Handler(new Handler.Callback() {
//        WeakReference<OkhttpActivity> mWeakReference= new WeakReference<OkhttpActivity>;

    @Override
    public boolean handleMessage(Message msg) {
      for (; ; ) {
//                Log.d("handlerdelay","what="+msg.what);
      }
    }
  });

  public OkhttpPresent(OkhttpActivity view) {
    super(view);
    mOkHttpClient = new OkHttpClient.Builder()
        .build();
//        mOkHttpClient.newBuilder().build();
//        httpurlconnection();

  }


  private void httpurlconnection() {
    HttpURLConnection connection = null;
    BufferedReader reader = null;
    try {
      URL url = new URL("https://www.baidu.com");
      connection = (HttpURLConnection) url.openConnection();     //获取实例
      connection.setRequestMethod("GET");                       //设置Http请求使用方法
      connection.setConnectTimeout(8000);                        //设置连接时的相关要求
      connection.setReadTimeout(8000);
      InputStream inputStream = connection.getInputStream();         //获取服务器返回的输入流

      //对上面读取到的数据进行读取
      reader = new BufferedReader(new InputStreamReader(inputStream));
      StringBuilder response = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        response.append(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void getRequst() {

    Request request = new Request.Builder().url(BaseUrl.GET_URL).build();

//        sync(okHttpClient, request);

    Async(mOkHttpClient, request);


  }

  private void Async(OkHttpClient okHttpClient, Request request) {
    Call call = okHttpClient.newCall(request);
    okHttpClient.newCall(request).enqueue(new Callback() {

      @Override
      public void onFailure(Call call, IOException e) {

      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        String s = response.body().string();
        Message msg = getMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString("mes", s);
        msg.setData(bundle);
        mHandler.sendMessage(getMessage(2));
        mHandler.sendMessageDelayed(getMessage(3000), 3000);
        mHandler.sendMessageDelayed(getMessage(4000), 4000);
        mHandler.sendMessageDelayed(getMessage(5000), 5000);
        mHandler.sendMessage(getMessage(6));
        mHandler.sendMessageDelayed(getMessage(6000), 6000);
        mHandler.sendMessageDelayed(getMessage(7000), 7000);
        mHandler.sendMessage(getMessage(8));
      }
    });
  }

  @NotNull
  private Message getMessage(int i) {
    Message msg = Message.obtain();
    msg.what = i;
    return msg;
  }

  private void sync(OkHttpClient okHttpClient, Request request) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Response mExecute = okHttpClient.newCall(request).execute();
          mview.runOnUiThread(new Runnable() {
            @Override
            public void run() {

              try {
                mview.showResult(mExecute.body().string());
              } catch (IOException e) {

              }
            }
          });
        } catch (IOException e) {
          e.printStackTrace();
        }


      }
    }).start();
  }

  @Override
  public void postRequst() {
    MediaType JSON = MediaType.get("application/json; charset=utf-8");
    BaseUrl baseUrl = new BaseUrl();
    String json = new Gson().toJson(baseUrl);
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder()
        .url(BaseUrl.GET_URL)
        .post(body)
        .build();
    mOkHttpClient.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {

      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        Log.d("okhttppresent", response.body().string());
      }
    });
  }

  static class Myhandle extends Handler {

    @Override
    public void handleMessage(Message msg) {
      super.handleMessage(msg);
    }
  }
}
