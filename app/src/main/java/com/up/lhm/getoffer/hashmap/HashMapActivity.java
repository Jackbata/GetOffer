package com.up.lhm.getoffer.hashmap;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.up.lhm.getoffer.R;
import com.up.lhm.getoffer.test.Ae;
import com.up.lhm.getoffer.test.Be;
import com.up.lhm.hmtools.system.IntentUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author lianghaimiao
 * @date 2019/3/4
 * @function
 */

public class HashMapActivity extends Activity {

    @BindView(R.id.arraylist)
    Button mArraylist;
    @BindView(R.id.btn)
    Button btn;
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
findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        SparseArray<String> stringSparseArray = new SparseArray<>();
        int[] mKeys = new int[10];

      int length = mKeys.length;
      Arrays.asList(mKeys);

      int i2 = binarySearch2(mKeys, mKeys.length, 4);
         stringSparseArray.put(4,"555");
         stringSparseArray.put(3,"355");
         stringSparseArray.put(6,"655");
         String k="";
         k.hashCode();
        int i4 = stringSparseArray.indexOfKey(4);
        int i3 = stringSparseArray.indexOfKey(3);
        int i6 = stringSparseArray.indexOfKey(6);
        Log.d("binarySearch2","i3="+i3+" ；i4="+i4+" ；i6="+i6+" ; res="+i2+"; ~res="+(~i2));

//        int[] mKeys = new int[10];
//        for (int i = 0; i < 8; i++) {
//        int r=    binarySearch2(mKeys, mKeys.length, i);
//        Log.d("binarySearch2","ordata="+i+" ; res="+r+" ;res1="+(~r));
//        }
    }
});
    }

    public  int binarySearch2(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }

    private void testData() {

    int a,d,f,e;
        //set
        HashSet<Object> hashSet = new HashSet<>();
        LinkedHashSet<String> strings1 = new LinkedHashSet<>();
        strings1.add("dd");

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
      ArrayList first = new ArrayList<Integer>();

      List<ArrayList<Integer>> listw  = new  ArrayList<>();
      ArrayList<Integer> listch =  new ArrayList<>();
      listw.add(listch);

      Object[] objects = first.toArray();
      //map
        HashMap<String, Integer> hm1 = new HashMap<>();
        Set<String> strings = hm1.keySet();
        HashMap<String, Integer> hm = new HashMap<>(1);
        hm1.put("", 11);
        hm.get("");

        Integer integer = hm.get("");
        Log.d("测试", integer + "");
       "".equals("w");
        LinkedHashMap<Object, Object> map = new LinkedHashMap<Object, Object>(1,1,true);
        map.put(null, null);
        map.put("q", "q");
        map.put(1, "q");
        map.get("3");
        map.remove("3");
       HashMap<Integer,Integer> mapwe =  new HashMap<Integer,Integer>();
        //  public final Iterator<Map.Entry<K,V>> iterator() {
        //            return new LinkedEntryIterator();
        //        }
        Set<Entry<Object, Object>> entries = map.entrySet();
        entries.iterator();
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("q", "q");
        concurrentHashMap.get("3");
      Hashtable<String, String> stringStringHashtable = new Hashtable<>();
        stringStringHashtable.put("q", "q");
        stringStringHashtable.get("q");


        ArrayMap<String, String> stringStringArrayMap = new ArrayMap<>();
        stringStringArrayMap.put("3", "ee");
        stringStringArrayMap.get("3");

        HashMap<String, Ae> stringAeHashMap = new HashMap<>();
        stringAeHashMap.put("1", new Be());
        stringAeHashMap.put("1", new Ae());
      stringAeHashMap.get("3");
        stringAeHashMap.remove("1");
        SparseArray<String> stringSparseArray = new SparseArray<>();
        stringSparseArray.put(1, "e");
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

//    @OnClick({R.id.arraylist,R.id.btn})
//    public void onViewClicked(View v) {
//        switch (v.getId()){
//          case  R.id.arraylist:
//            listExpection();
//            break;
//            case  R.id.btn:
//                SparseArray<String> stringSparseArray = new SparseArray<>();
//                stringSparseArray.put(8, "e");
//                break;
//        }
//
//    }
    private void listExpection() {

        ArrayList<Integer> list = new ArrayList<>();
      int[] ints = new int[list.size()];
      int[] ints1 =new  int[] {1, 2};
      list.toArray(new int[][]{ints});
      for (Integer item:list) {
            if (item==3){
                list.remove(item);
            }
        }

        copywritearrlist();

//        arrlistdemo();

    }

    private void copywritearrlist() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            copyOnWriteArrayList.add(i+"");
        }
        copyOnWriteArrayList.get(1);
        copyOnWriteArrayList.remove(1);
        Iterator<String> iterator2 = copyOnWriteArrayList.iterator();
        while (iterator2.hasNext()){
            String next = iterator2.next();
            if (TextUtils.equals(next,"3")) copyOnWriteArrayList.add(0,"eee");
           Log.d("copyOnWriteArrayList",next);
        }
    }

    private void arrlistdemo() {
       //ArrayList Iterator
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i*10);
            list.add(1,2);
        }
        Iterator<Integer> iterator = list.listIterator();

        Iterator<Integer> iterator2 = list.iterator();
        iterator2.remove();

        while(iterator.hasNext()){
            if(iterator.next()==30){
                iterator.remove();
            }
        }

        //LinkedList Iterator
        LinkedList<String> string = new LinkedList<>();
        string.add("3");
        string.get(1);
        string.remove(1);

        Iterator<String> iterator1 = string.iterator();
        Iterator<String> iterator12 = string.listIterator();
        while(iterator1.hasNext()){
            if(iterator1.next()=="3"){
                iterator1.remove();
            }
        }

      String str=new String("abc");
      WeakReference<String> abcWeakRef = new WeakReference<String>(str);
      String s = abcWeakRef.get();
    }

}
