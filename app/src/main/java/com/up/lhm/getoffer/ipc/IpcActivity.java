package com.up.lhm.getoffer.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author barry
 * @date 2020/5/23
 * @function
 */

public class IpcActivity extends BaseActivity {
    @BindView(R.id.ipc)
    Button mIpc;
    @BindView(R.id.other)
    Button mOther;
    @BindView(R.id.result)
    TextView mResult;

    public static void start(Context context, boolean b) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, IpcActivity.class, b, args);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ipc;
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
                break;
            default:
                break;
        }
    }
}
