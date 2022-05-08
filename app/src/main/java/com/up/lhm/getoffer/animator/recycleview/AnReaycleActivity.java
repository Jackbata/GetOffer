package com.up.lhm.getoffer.animator.recycleview;

import android.content.Context;
import android.os.Bundle;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;

/**
 * @author lianghaimiao
 * @date 2019/3/31
 * @function
 */

public class AnReaycleActivity extends BaseActivity {


    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, AnReaycleActivity.class, finishSelf, args);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.animator_recycle_layout;
    }

    @Override
    public void initData() {

    }
}
