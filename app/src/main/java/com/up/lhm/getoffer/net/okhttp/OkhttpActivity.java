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
}
