package com.up.lhm.getoffer.rxjava;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.getoffer.rxjava.Contract.Rxjavaview;
import com.up.lhm.getoffer.rxjava.present.ComposePresent;
import com.up.lhm.getoffer.rxjava.present.ConnectablePresent;
import com.up.lhm.getoffer.rxjava.present.CreatePresent;
import com.up.lhm.getoffer.rxjava.present.CustomOperatPresent;
import com.up.lhm.getoffer.rxjava.present.FiliteObservablePresent;
import com.up.lhm.getoffer.rxjava.present.TransferPresent;
import com.up.lhm.hmtools.system.IntentUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ConstraintLayout
 * https://www.jianshu.com/p/17ec9bd6ca8a
 */
public class RxjavaActivity extends BaseActivity implements Rxjavaview {


    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.btn1)
    Button mBtn1;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, RxjavaActivity.class, finishSelf, args);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rxjava;
    }


    @Override
    public void initData() {

    }

    @OnClick({R.id.btn, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                CreatePresent createPresent = new CreatePresent(this);
                createPresent.createObservable();
                break;
            case R.id.btn1:
                new TransferPresent(this).exectObservable();

                break;
            case R.id.btn2:
                new FiliteObservablePresent(this).exectObservable();
                break;
            case R.id.btn4:
                new CustomOperatPresent(this).exectObservable();
                break;
            case R.id.btn5:
                new ConnectablePresent(this).exectObservable();
                break;
                default:
                    break;
        }
    }






    @Override
    protected void onDestroy() {
        super.onDestroy();}
}
