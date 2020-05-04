package com.up.lhm.getoffer.net.okhttp;

import com.up.lhm.getoffer.mvp.base.BasePresenter;
import com.up.lhm.getoffer.net.url.BaseUrl;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author lianghaimiao
 * @date 2020-04-23
 * @function
 */

public class OkhttpPresent extends BasePresenter<OkhttpActivity> implements Contract.OkhttpPresent {



    public OkhttpPresent(OkhttpActivity view) {
        super(view);
    }

    @Override
    public void getRequst() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.socketFactory()
        Request request =new Request.Builder().url(BaseUrl.GET_URL).build();

//        sync(okHttpClient, request);

        Async(okHttpClient, request);

    }

    private void Async(OkHttpClient okHttpClient, Request request) {
        okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String s = response.body().string();
                    mview.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mview.showResult(s);

                        }
                    });
                }
            });
    }

    private void sync(OkHttpClient okHttpClient, Request request) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response mExecute= okHttpClient.newCall(request).execute();
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

    }
}
