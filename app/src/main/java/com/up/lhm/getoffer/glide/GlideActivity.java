package com.up.lhm.getoffer.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.facebook.drawee.view.SimpleDraweeView;
import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.mvp.activity.Contract.Xview;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.hmtools.system.IntentUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lianghaimiao
 * @date 2019/3/14
 * @function
 * https://www.fresco-cn.org/docs/concepts.html
 */

public class GlideActivity extends BaseActivity implements Xview {

    @BindView(R.id.iv_glide)
    ImageView mIvGlide;
    @BindView(R.id.btn_show_image)
    Button mBtnShowImage;
    @BindView(R.id.ll_glide)
    LinearLayout mLlGlide;
    @BindView(R.id.iv_fresco)
    SimpleDraweeView mIvFresco;
    @BindView(R.id.btn_fresco)
    Button mBtnFresco;
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

        HashMap map = new HashMap<String, String>(12);
        map.put("12", "12");
        map.get("12");
        map.remove("12");
        map.clear();

        LinkedHashMap linkedmap = new LinkedHashMap<String, Integer>(12);
        linkedmap.put("1", 1);
        linkedmap.get("1");
        linkedmap.remove("1");
        linkedmap.clear();
    }

    @Override
    public void showview() {

    }


    @OnClick({R.id.btn_show_image, R.id.btn_fresco})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.btn_show_image:
                setGlide();
                break;
            case R.id.btn_fresco:
                setFresco();
                break;
            default:
                break;
        }


    }

    private void setFresco() {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Uri uri = Uri.parse(url);
        mIvFresco.setImageURI(uri);
    }

    private void setGlide() {
        String url = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3632677651,3179755979&fm=26&gp=0.jpg";
        //动图
//        String url = "http://p1.pstatp.com/large/166200019850062839d3";

        SimpleTarget target = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource,
                    GlideAnimation<? super Bitmap> glideAnimation) {
                mIvGlide.setImageBitmap(resource);
            }
        };

        Glide.with(this)
                .load(url)
                .asBitmap()
                .into(mIvGlide);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
