package com.up.lhm.getoffer.mvp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.activity.Contract.Xview;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author lianghaimiao
 * @date 2019/3/14
 * @function
 */

public class ViewActivity extends BaseActivity implements Xview {

    @BindView(R.id.rv)
    RecyclerView mRv;

    @BindView(R.id.tvtext)
    TextView mTvtext;

    private MPresent mPresent;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, ViewActivity.class, finishSelf, args);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        mPresent = new MPresent(ViewActivity.this);
        mPresent.setdata();
    }

    @Override
    public void showview() {

    }
    @OnClick({R.id.rv, R.id.tvtext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rv:
                break;
            case R.id.tvtext:
                break;
        }
    }
}
