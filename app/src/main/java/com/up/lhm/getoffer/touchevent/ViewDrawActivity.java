package com.up.lhm.getoffer.touchevent;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.camera.CameraActivity2;
import com.up.lhm.getoffer.hotfix.HotfixTest;
import com.up.lhm.hmtools.system.IntentUtil;
import com.up.lhm.hmtools.system.Log;

/**
 * @author lianghaimiao
 * @date 2019/3/1
 * @function
 */

public class ViewDrawActivity extends AppCompatActivity {
    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, ViewDrawActivity.class, finishSelf, args);
    }
    @Override
    protected void onCreate(@Nullable   Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_viewdraw);
    }

}
