package com.up.lhm.getoffer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.up.lhm.getoffer.MyAdapter.OnItemClickListener;
import com.up.lhm.getoffer.bean.DataList;
import com.up.lhm.getoffer.hashmap.HashMapActivity;
import com.up.lhm.getoffer.touchevent.EventDispatchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianghaimiao
 */
public class MainActivity extends AppCompatActivity {
    /**
     * 技能点列表
     */
    private RecyclerView mRv;
    /**
     * 技能点列表
     */
    private List<DataList> mList = new ArrayList<>();
    private String[] mDataList = {"事件分发机制", "HashMap原理", "可继续填充"};
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initRv();
        setListener();
    }

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
                    default:
                        break;
                }
            }
        });


    }

}
