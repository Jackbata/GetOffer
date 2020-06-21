package com.up.lhm.getoffer;

import com.google.gson.Gson;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.up.lhm.annotationlibs.BindVieww;
import com.up.lhm.getoffer.MyAdapter.OnItemClickListener;
import com.up.lhm.getoffer.aidl.AIDLActivity;
import com.up.lhm.getoffer.arouter.ArouterMainActivity;
import com.up.lhm.getoffer.bean.DataList;
import com.up.lhm.getoffer.dragger.DraggerActivity;
import com.up.lhm.getoffer.glide.GlideActivity;
import com.up.lhm.getoffer.greendao.GreendaoActivity;
import com.up.lhm.getoffer.hashmap.HashMapActivity;
import com.up.lhm.getoffer.image.ImageActivity;
import com.up.lhm.getoffer.ipc.IpcActivity;
import com.up.lhm.getoffer.jsbridge.JSActivity;
import com.up.lhm.getoffer.mvp.activity.ViewActivity;
import com.up.lhm.getoffer.mvp.base.BaseActivity;
import com.up.lhm.getoffer.net.okhttp.OkhttpActivity;
import com.up.lhm.getoffer.notes.GetUrl;
import com.up.lhm.getoffer.notes.TestAnnotate;
import com.up.lhm.getoffer.rxjava.RxjavaActivity;
import com.up.lhm.getoffer.threadpool.ThreadPoolsActivity;
import com.up.lhm.getoffer.touchevent.EventDispatchActivity;
import com.up.lhm.getoffer.viewscoller.ViewScollerActivity;
import com.up.lhm.getoffer.webview.WebviewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianghaimiao
 */
public class MainActivity extends BaseActivity {
    /**
     * 编译时注解控件
     */
    @BindVieww(value = R.id.tvtext)
    TextView tvtext;


    /**
     * 技能点列表
     */
    private RecyclerView mRv;
    /**
     * 技能点列表
     */
    private List<DataList> mList = new ArrayList<>();
    private String[] mDataList = {"事件分发机制", "HashMap原理", "线程池", "动画原理", "view滑动", "MVP", "Arouter",
            "dragger2",
            "greendao", "jsbridage", "图片框架", "rxjava", "okhttp", "跳转第三方应用", "webview", "图片适配",
            "AIDL",
            "可继续填充"};
    private MyAdapter mAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @TestAnnotate(index = 1, name = "李四")
    @GetUrl(url = "https://www.baidu.com/s?i")
    private void initView() {
        mRv = findViewById(R.id.rv);
    }

    @Override
    public void initData() {
        initView();

        initrvdata();

        initRv();
        setListener();


    }

    private void initrvdata() {
        for (int i = 0; i < mDataList.length; i++) {
            DataList dataList = new DataList();
            dataList.index = i;
            dataList.name = mDataList[i];
            mList.add(dataList);
        }
    }

    private void initRv() {
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRv.setLayoutManager(linearLayoutManager);
        mAdapter = new MyAdapter(mList);
        mRv.setAdapter(mAdapter);
        mRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void setListener() {
        mAdapter.setmOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        EventDispatchActivity.start(MainActivity.this, false);
                        break;
                    case 1:
                        HashMapActivity.start(MainActivity.this, false);
                        break;
                    case 2:
                        ThreadPoolsActivity.start(MainActivity.this, false);
                        break;
                    case 3:
                        AntimatorsActivity.start(MainActivity.this, false);
                        break;
                    case 4:
                        ViewScollerActivity.start(MainActivity.this, false);
                        break;
                    case 5:
                        ViewActivity.start(MainActivity.this, false);
                        break;
                    case 6:
                        ArouterMainActivity.start(MainActivity.this, false);
                        break;
                    case 7:
                        DraggerActivity.start(MainActivity.this, false);
                        break;
                    case 8:
                        GreendaoActivity.start(MainActivity.this, false);
                        break;
                    case 9:
                        JSActivity.start(MainActivity.this, false);
                        break;
                    case 10:
                        GlideActivity.start(MainActivity.this, false);
                        break;
                    case 11:
                        RxjavaActivity.start(MainActivity.this, false);
                        break;
                    case 12:
                        OkhttpActivity.start(MainActivity.this, false);
                        break;
                    case 13:
                        IpcActivity.start(MainActivity.this, false);
                        break;
                    case 14:
                        WebviewActivity.start(MainActivity.this, false);
                        break;
                    case 15:
                        ImageActivity.start(MainActivity.this, false);
                        break;
                    case 16:
                        AIDLActivity.start(MainActivity.this, false);
                        break;
                    default:
                        break;
                }
            }
        });


    }

    public String geturl() {

        return "";
    }

    public String dev() {
        //dev第一次提交远程分支
        //dev第2次提交远程分支
        //dev第3次提交远程分支
        // dev第4次提交远程分支
       // dev第5次提交远程分支
        // dev第6次提交远程分支
        // dev第7次提交远程分支
        // dev第8次提交远程分支
        // dev第9次提交远程分支

        return "";
    }
    public String featch() {
        //featch第一次提交远程分支
        //featch第er次提交远程分支
        //featch第3次提交远程分支
        //featch第4次提交远程分支
        //featch第5次提交远程分支
        //featch第6次提交远程分支
        //featch第7次提交远程分支

        return "";
    }

}
