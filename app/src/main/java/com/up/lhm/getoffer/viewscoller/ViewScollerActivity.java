package com.up.lhm.getoffer.viewscoller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.up.lhm.getoffer.R;
import com.up.lhm.hmtools.system.IntentUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lianghaimiao
 * @date 2019/4/4
 * @function
 */

public class ViewScollerActivity extends Activity implements OnClickListener {
    @BindView(R.id.view_scollby)
    Button mViewScollby;
    @BindView(R.id.view_scollto)
    Button mViewScollto;
    @BindView(R.id.view_scoller)
    Button mViewScoller;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, ViewScollerActivity.class, finishSelf, args);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_scoller);
        ButterKnife.bind(this);
        mViewScollby.setOnClickListener(this);
        mViewScollto.setOnClickListener(this);
        mViewScoller.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.view_scollby:
                mViewScollby.scrollBy(-20,0);
                break;
            case R.id.view_scollto:
                mViewScollto.scrollTo(-20,0);
                break;
            case R.id.view_scoller:
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
