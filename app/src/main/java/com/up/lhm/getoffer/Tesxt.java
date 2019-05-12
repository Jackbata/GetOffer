package com.up.lhm.getoffer;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.SparseArray;


import com.up.lhm.getoffer.arith.Iteration;
import com.up.lhm.getoffer.arith.ListNode;
import com.up.lhm.getoffer.singleton.Student;

import java.io.BufferedInputStream;
import java.lang.reflect.Field;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author lianghaimiao
 * @date 2019/3/11
 * @function
 */

public class Tesxt {


    public static void main(String[] args) {

        int [] arr={1,2,3,4};
        for (int i:arr) {
            System.out.print(i);
        }
//        int   a=123;
//        put123(a);
        System.out.print("de"+(1^1));
//                String aa="d";
//        int aasdfrr = firstUniqChar("z");



    }

    public static int firstUniqChar(String s) {
        if(s == null){
            return -1;
        }
        char[] arr =s.toCharArray();
        int length = arr.length;

        for (int i=0;i<length-1;i++){
            int temp =length-1-i;

            for(int j=i+1;j<length;j++){
                if(arr[i]==arr[j]){
                    break;
                }
                temp--;

            }
            if(temp==0){
                return i;
            }
        }

        return -1;
    }
    private static void put123(int a) {
        a=32;
    }

    public static Tesxt getInstance() throws Exception {
        return null;
    }
}
