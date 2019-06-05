package com.up.lhm.getoffer.dragger;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.up.lhm.getoffer.MainActivity;
import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.dragger.bean.Car;
import com.up.lhm.getoffer.dragger.bean.Engine;
import com.up.lhm.getoffer.dragger.bean.Worker;
import com.up.lhm.hmtools.system.IntentUtil;

import javax.inject.Inject;
import javax.inject.Named;

public class DraggerActivity extends AppCompatActivity {
    @Inject
    Car car;

    @Inject
    Worker worker;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, DraggerActivity.class, finishSelf, args);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragger);
        App.getComponent(this).getActivityComponen().inject(this);
    }
}
