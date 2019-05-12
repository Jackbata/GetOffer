package com.up.lhm.getoffer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.up.lhm.annotationlibs.BindVieww;
import com.up.lhm.annotationlibs.MyClass;
import com.up.lhm.getoffer.MyAdapter.OnItemClickListener;
import com.up.lhm.getoffer.bean.DataList;
import com.up.lhm.getoffer.hashmap.HashMapActivity;
import com.up.lhm.getoffer.mvp.activity.ViewActivity;
import com.up.lhm.getoffer.notes.GetUrl;
import com.up.lhm.getoffer.notes.TestAnnotate;
import com.up.lhm.getoffer.threadpool.ThreadPoolsActivity;
import com.up.lhm.getoffer.touchevent.EventDispatchActivity;
import com.up.lhm.getoffer.viewscoller.ViewScollerActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;

/**
 * @author lianghaimiao
 */
public class MainActivity extends AppCompatActivity {
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
    private String[] mDataList = {"事件分发机制", "HashMap原理", "线程池", "动画原理", "view滑动", "MVP", "可继续填充"};
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initRv();
        setListener();
        SharedPreferences sp = this.getSharedPreferences("aa", Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        edit.putBoolean("ss", true);
        boolean commit = edit.commit();
        edit.apply();

        boolean ss = sp.getBoolean("ss", false);
    }

    @TestAnnotate(index = 1, name = "李四")
    @GetUrl(url = "https://www.baidu.com/s?i")
    private void initView() {
        mRv = findViewById(R.id.rv);
    }

    private void initData() {
        for (int i = 0; i < mDataList.length; i++) {
            DataList dataList = new DataList();
            dataList.index = i;
            dataList.name = mDataList[i];
            mList.add(dataList);
        }

    }

    private void initRv() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
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
                    default:
                        break;
                }
            }
        });


    }

    public String geturl() {
        return "";
    }
}
