package com.up.lhm.mylibrary;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lianghaimiao
 * @date 2019/5/11
 * @function
 */

public class MoginActivity extends Activity {


    @BindView(R2.id.rv3)
    RecyclerView mRv3;
    @BindView(R2.id.tvtext3)
    TextView mTvtext3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
