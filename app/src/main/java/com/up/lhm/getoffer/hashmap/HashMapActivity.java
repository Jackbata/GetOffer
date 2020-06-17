package com.up.lhm.getoffer.hashmap;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LruCache;
import android.util.SparseArray;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.test.Ae;
import com.up.lhm.getoffer.test.Be;
import com.up.lhm.hmtools.system.IntentUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author lianghaimiao
 * @date 2019/3/4
 * @function
 */

public class HashMapActivity extends Activity {

    @BindView(R.id.arraylist)
    Button mArraylist;
    private ListView mListView;
    private ListAdapter mAdapter;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, HashMapActivity.class, finishSelf, args);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_hashmap);
        ButterKnife.bind(this);
//        initview();
//        testData();
//        initData();
    }


    private void testData() {

        //set
        HashSet<Object> hashSet = new HashSet<>();
        LinkedHashSet<String> strings1 = new LinkedHashSet<>();
        hashSet.add(12);
        TreeSet<String> treeset = new  TreeSet<String>();
        treeset.add("33");

        //list
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.get(0);
        linkedList.remove("1");

        ArrayList<String> list = new ArrayList<>();
        list.add("2");
        list.get(1);
        list.remove(1);

        //map
        HashMap<String, Integer> hm1 = new HashMap<>();
        Set<String> strings = hm1.keySet();
        HashMap<String, Integer> hm = new HashMap<>(1);
        hm.put("", 11);
        hm.get("");

        Integer integer = hm.get("");
        Log.d("测试", integer + "");

        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        map.put(null, null);
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("q", "q");

        Hashtable<String, String> stringStringHashtable = new Hashtable<>();
        stringStringHashtable.put("q", "q");
        stringStringHashtable.get("q");

        ArrayMap<String, String> stringStringArrayMap = new ArrayMap<>();
        stringStringArrayMap.put("3", "ee");
        stringStringArrayMap.get("3");

        HashMap<String, Ae> stringAeHashMap = new HashMap<>();
        stringAeHashMap.put("1", new Be());
        stringAeHashMap.put("1", new Ae());

        SparseArray<String> stringSparseArray = new SparseArray<>();
        stringSparseArray.put(1, "e");

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("ss");
        threadLocal.get();

        ThreadLocal<String> tl = new ThreadLocal<>();
        tl.set("ces");
        tl.get();
    }

    private void initview() {
        mListView = findViewById(R.id.lv);
    }

    private void initData() {
        String[] data = new String[20];
        for (int i = 0; i < 20; i++) {
            data[i] = "第" + i + "个数据";
        }
        mAdapter = new MyAdapter(data, this);
        mListView.setAdapter(mAdapter);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @OnClick(R.id.arraylist)
    public void onViewClicked() {
        listExpection();
    }
    private void listExpection() {


//        for (Integer item:list) {
//            if (item==3){
//                list.remove(item);
//            }
//        }

        copywritearrlist();

//        arrlistdemo();

    }

    private void copywritearrlist() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            copyOnWriteArrayList.add(i+"");
        }
        copyOnWriteArrayList.get(1);
        Iterator<String> iterator2 = copyOnWriteArrayList.iterator();
        while (iterator2.hasNext()){
            String next = iterator2.next();
            if (TextUtils.equals(next,"3")) copyOnWriteArrayList.add(0,"eee");
           Log.d("copyOnWriteArrayList",next);
        }
    }

    private void arrlistdemo() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i*10);
            list.add(1,2);
        }
        LinkedList<String> string = new LinkedList<>();
        string.add("3");
        Iterator<String> iterator1 = string.iterator();
        Iterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext()){
            if(iterator.next()==30){
                iterator.remove();
            }
        }
    }

}
