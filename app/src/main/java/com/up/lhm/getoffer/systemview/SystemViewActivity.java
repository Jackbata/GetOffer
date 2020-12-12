package com.up.lhm.getoffer.systemview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;

public class SystemViewActivity extends BaseActivity {

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, SystemViewActivity.class, finishSelf, args);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_system_view;
    }

    @Override
    protected void initBaseView() {
     findViewById(R.id.textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void initData() {

    }
}
