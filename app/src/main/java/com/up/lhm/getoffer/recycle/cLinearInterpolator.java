package com.up.lhm.getoffer.recycle;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.animation.BaseInterpolator;
import android.view.animation.LinearInterpolator;

import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.Log;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2020/12/12 7:03 PM
 */
public class cLinearInterpolator extends LinearInterpolator {
    @Override
    public float getInterpolation(float input) {
        Log.d("demo测试","input="+input);
        return input;
    }
}
