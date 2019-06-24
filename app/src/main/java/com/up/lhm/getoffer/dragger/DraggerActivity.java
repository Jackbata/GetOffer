package com.up.lhm.getoffer.dragger;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.up.lhm.getoffer.App;
import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.dragger.bean.Car;
import com.up.lhm.getoffer.dragger.bean.Worker;
import com.up.lhm.hmtools.system.IntentUtil;

import javax.inject.Inject;

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
