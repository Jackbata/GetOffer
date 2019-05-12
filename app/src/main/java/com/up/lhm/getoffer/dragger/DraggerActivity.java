package com.up.lhm.getoffer.dragger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.dragger.bean.Car;
import com.up.lhm.getoffer.dragger.bean.Worker;

import javax.inject.Inject;

public class DraggerActivity extends AppCompatActivity {
    @Inject
    Car car;
    @Inject
    Worker worker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragger);
        App.getComponent(this).getActivityComponen().inject(this);
    }
}
