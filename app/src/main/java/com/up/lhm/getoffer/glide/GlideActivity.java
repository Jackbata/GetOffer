package com.up.lhm.getoffer.glide;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.activity.Contract.Xview;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lianghaimiao
 * @date 2019/3/14
 * @function
 */

public class GlideActivity extends BaseActivity implements Xview {

    @BindView(R.id.iv_glide)
    ImageView mIvGlide;
    @BindView(R.id.btn_show_image)
    Button mBtnShowImage;
    private GlidePresent mPresent;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, GlideActivity.class, finishSelf, args);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_glide;
    }

    @Override
    public void initData() {
        mPresent = new GlidePresent(GlideActivity.this);
        mPresent.setdata();
    }

    @Override
    public void showview() {

    }


    @OnClick(R.id.btn_show_image)
    public void onViewClicked() {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        //动图
//        String url = "http://p1.pstatp.com/large/166200019850062839d3";
        Glide.with(this)
                .load(url)
                .override(200,200)
                .into(mIvGlide);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
