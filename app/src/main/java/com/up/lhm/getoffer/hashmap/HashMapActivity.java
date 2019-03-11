package com.up.lhm.getoffer.hashmap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.touchevent.EventDispatchActivity;
import com.up.lhm.hmtools.system.IntentUtil;

import java.util.HashMap;
import java.util.Hashtable;


/**
 * @author lianghaimiao
 * @date 2019/3/4
 * @function
 */

public class HashMapActivity extends Activity {

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, HashMapActivity.class, finishSelf, args);
    }

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_hashmap);
        HashMap<String, Integer> hm = new HashMap<>();
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        objectObjectHashtable.put(1,1);
        hm.put("",11);
        Integer integer = hm.get("");
        Log.d("测试",integer+"");
    }
}
