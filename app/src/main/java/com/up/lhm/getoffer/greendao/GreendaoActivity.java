package com.up.lhm.getoffer.greendao;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.up.lhm.getoffer.R;
import com.up.lhm.hmtools.system.IntentUtil;

/**
 * @author Barry
 * @date 2019-06-05
 * @function
 */

public class GreendaoActivity extends AppCompatActivity {
    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, GreendaoActivity.class, finishSelf, args);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);
    }
}
