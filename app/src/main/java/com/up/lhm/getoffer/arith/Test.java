package com.up.lhm.getoffer.arith;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author lianghaimiao
 * @date 2019/3/31
 * @function
 */

public class Test {

    public static void main(String[] args) {
//        testnode();
//
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("w");
//        LinkedList<String> LinkedList = new LinkedList<>();
//        LinkedList.add("s");
//
//        ArrayMap<String, String> arrayMap = new ArrayMap<>();
//        arrayMap.put("test", "aa");
//
//        SparseArray<String> stringSparseArray = new SparseArray<>();
//        stringSparseArray.put(1, "s");
//        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put("d", "d");
//       HashMap<String, String> HashMap = new HashMap<>();
//        HashMap.put("d", "d");
//        List list = Collections.synchronizedList(new ArrayList());
        // 第三个参数用于指定accessOrder值
//        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
//        linkedHashMap.put("name1", "josan1");
//        linkedHashMap.put("name2", "josan2");
//        linkedHashMap.put("name3", "josan3");
//        System.out.println("开始时顺序：");
//        Set<Entry<String, String>> set = linkedHashMap.entrySet();
//        Iterator<Entry<String, String>> iterator = set.iterator();
//        while(iterator.hasNext()) {
//            Entry entry = iterator.next();
//            String key = (String) entry.getKey();
//            String value = (String) entry.getValue();
//            System.out.println("key:" + key + ",value:" + value);
//        }
//        System.out.println("通过get方法，导致key为name1对应的Entry到表尾");
//        linkedHashMap.get("name1");
//        Set<Entry<String, String>> set2 = linkedHashMap.entrySet();
//        Iterator<Entry<String, String>> iterator2 = set2.iterator();
//        while(iterator2.hasNext()) {
//            Entry entry = iterator2.next();
//            String key = (String) entry.getKey();
//            String value = (String) entry.getValue();
//            System.out.println("key:" + key + ",value:" + value);
//        }
        int[] mKeys = new int[10];
        int i = binarySearch2(mKeys, mKeys.length, 8);
        int b=i;
    }

     public static int binarySearch2(int[] array, int size, int value) {
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

    private static void testnode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = reverseList(listNode1);
        new Thread().start();
        }


    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
