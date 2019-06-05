package com.up.lhm.getoffer.arouter.testactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.up.lhm.getoffer.R;
import com.up.lhm.hmtools.system.ToastUtils;

/**
 * @author lianghaimiao
 * @date 2019/5/23
 * @function
 */
@Route(path = "/test/activity2")
public class Test2Activity extends AppCompatActivity {
    @Autowired
    String key1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        String value = getIntent().getStringExtra("key1");
        if (!TextUtils.isEmpty(value)) {
            ToastUtils.showLong("exist param :" + value);
        }

        setResult(999);
    }
}
