package com.up.lhm.getoffer.image;


import android.content.Context;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.getoffer.webview.WebviewActivity;
import com.up.lhm.hmtools.system.IntentUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author barry
 * @date 2020/5/29
 * @function
 */

public class ImageActivity extends BaseActivity {
    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, ImageActivity.class, finishSelf, args);
    }
    @BindView(R.id.listview)
    ListView mListview;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_image;
    }

    @Override
    public void initData() {
        List<Integer> mlist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mlist.add(R.drawable.timg);
        }
        MyListAdapter adapter = new MyListAdapter(this, mlist);
        mListview.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
