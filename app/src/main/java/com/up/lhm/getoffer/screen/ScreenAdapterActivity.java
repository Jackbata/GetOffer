package com.up.lhm.getoffer.screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import butterknife.OnClick;
import com.libs.screenadapter.screen.util.ScreenAdapterUtils;
import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;
import dalvik.system.DexClassLoader;

/**
 * @author barry
 * @date 2020/5/23
 * @function
 */

public class ScreenAdapterActivity extends BaseActivity {


    public static void start(Context context, boolean b) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, ScreenAdapterActivity.class, b, args);
    }

    @Override
    protected int getLayoutId() {
        Toast.makeText(this, "getLayoutId", Toast.LENGTH_SHORT).show();
        return R.layout.activity_screen_adapter;
    }

    @Override
    public void initData() {

    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @OnClick({R.id.ipc, R.id.other})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ipc:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setPackage("com.up.share.customview");
                startActivity(intent);
                break;
            case R.id.other:

                try {
                    DexClassLoader dexpath = new DexClassLoader("dexpath",
                        this.getCacheDir().getAbsolutePath(), null, this.getClassLoader());
                    Class<?> dd = dexpath.loadClass("dd");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

}
