package com.up.lhm.getoffer.net.okhttp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.getoffer.net.okhttp.Contract.OkhttpView;
import com.up.lhm.hmtools.system.IntentUtil;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author lianghaimiao
 * @date 2020-04-23
 * @function
 */

public class OkhttpActivity extends BaseActivity implements OkhttpView {
    @BindView(R.id.get)
    Button mGet;
    @BindView(R.id.post)
    Button mPost;
    @BindView(R.id.result)
    TextView mResult;
    private OkhttpPresent mOkhttpPresent;



    public static void start(Context context, boolean b) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, OkhttpActivity.class, b, args);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_okhttp;
    }

    @Override
    public void initData() {
        mOkhttpPresent = new OkhttpPresent(this);
    }

    @Override
    public void showResult(String result) {
                mResult.setText(result);
    }

    @OnClick({R.id.get, R.id.post})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.get:
                mOkhttpPresent.getRequst();
                break;
            case R.id.post:
                mOkhttpPresent.postRequst();
                break;
            default:
                break;
        }
    }
    private void retrofit() {
        //步骤4:创建Retrofit对象
//        RestAdapter.Builder builder = new RestAdapter.Builder();

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(new OkHttpClient())
            .build();

        // 步骤5:创建 网络请求接口 的实例
        PostRequest_Interface request = retrofit.create(PostRequest_Interface.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<Translation1> call = request.getCall("I love you");

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Translation1>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<Translation1> call, Response<Translation1> response) {
                // 步骤7：处理返回的数据结果：输出翻译的内容
                System.out.println(response.body().getTranslateResult().get(0).get(0).getTgt());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation1> call, Throwable throwable) {
                System.out.println("请求失败");
                System.out.println(throwable.getMessage());
            }
        });
    }
}
