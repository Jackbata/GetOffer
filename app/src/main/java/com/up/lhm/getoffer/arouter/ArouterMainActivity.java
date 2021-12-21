package com.up.lhm.getoffer.arouter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.up.lhm.getoffer.R;
import com.up.lhm.hmtools.system.IntentUtil;
import com.up.lhm.hmtools.system.Log;
import com.up.lhm.hmtools.system.ToastUtils;

import butterknife.ButterKnife;

/**
 * @author lianghaimiao
 */
public class ArouterMainActivity extends AppCompatActivity {
    private static Activity activity;
    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, ArouterMainActivity.class, finishSelf, args);

    }


    public static Activity getThis() {
        return activity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter_main);
        ButterKnife.bind(this);
        ARouter.openDebug();
        ARouter.init(getApplication());
        activity = this;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.openLog:
                ARouter.openLog();
                break;
            case R.id.openDebug:
                ARouter.openDebug();
                break;
            case R.id.init:
                ARouter.openDebug();
                ARouter.init(getApplication());
                break;
            case R.id.destroy:
                ARouter.getInstance().destroy();
                break;
            case R.id.normalNavigation:
                ARouter.getInstance().build("/test/activity2")
                        .withString("key1", "activity2")
                        .navigation();
                break;
            case R.id.kotlinNavigation:
                break;
            case R.id.normalNavigation2:
                ARouter.getInstance()
                        .build("/test/activity2")
                        .navigation(this, 666);
                break;
            case R.id.getFragment:
                Fragment blankFragment = (Fragment) ARouter.getInstance().build("/test/fragment")
                        .navigation();
                ToastUtils.showShort(blankFragment.toString());
                break;
            case R.id.normalNavigationWithParams:
                Uri testUriMix = Uri.parse("arouter://m.aliyun.com/test/activity2");
                ARouter.getInstance().build(testUriMix)
                        .withString("key1", "value1")
                        .navigation();
                break;
            case R.id.oldVersionAnim:
                break;
            case R.id.newVersionAnim:
                break;
            case R.id.navByUrl:
                break;
            case R.id.interceptor:
                ARouter.getInstance()
                        .build("/test/activity4")
                        .navigation(this, new NavCallback() {
                            @Override
                            public void onArrival(Postcard postcard) {

                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.d("activity4 被拦截了");
                            }
                        });
                break;
            case R.id.autoInject:
                break;
            case R.id.navByName:
                break;
            case R.id.navByType:
                break;
            case R.id.callSingle:
                break;
            case R.id.navToMoudle1:
                break;
            case R.id.navToMoudle2:
                break;
            case R.id.failNav:
                break;
            case R.id.failNav2:
                break;
            case R.id.failNav3:
                break;
            case R.id.activity_main:

                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 666:
                ToastUtils.showShort(String.valueOf(resultCode));
                break;
            default:
                break;
        }


    }

    @Override
    protected void onDestroy() {
        ARouter.getInstance().destroy();
        super.onDestroy();
    }
}
