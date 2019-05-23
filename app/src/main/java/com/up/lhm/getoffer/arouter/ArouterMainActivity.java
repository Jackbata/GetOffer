package com.up.lhm.getoffer.arouter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.up.lhm.getoffer.R;
import com.up.lhm.hmtools.system.IntentUtil;

import butterknife.ButterKnife;

/**
 * @author lianghaimiao
 */
public class ArouterMainActivity extends AppCompatActivity {
    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, ArouterMainActivity.class, finishSelf, args);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter_main);
        ButterKnife.bind(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.openLog:
                break;
            case R.id.openDebug:
                break;
            case R.id.init:
                break;
            case R.id.destroy:
                break;
            case R.id.normalNavigation:
                break;
            case R.id.kotlinNavigation:
                break;
            case R.id.normalNavigation2:
                break;
            case R.id.getFragment:
                break;
            case R.id.normalNavigationWithParams:
                break;
            case R.id.oldVersionAnim:
                break;
            case R.id.newVersionAnim:
                break;
            case R.id.navByUrl:
                break;
            case R.id.interceptor:
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

}
