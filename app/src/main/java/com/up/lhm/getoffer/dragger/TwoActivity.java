package com.up.lhm.getoffer.dragger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.up.lhm.getoffer.App;
import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.dragger.bean.Swadman;

import javax.inject.Inject;

import dagger.Lazy;

public class TwoActivity extends AppCompatActivity {
    @Inject
    Lazy<Swadman> mSwadmanLazy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        App.getComponent(this).getActivityComponen().inject(this);
        Swadman swadman = mSwadmanLazy.get();
    }
}
