package com.up.lhm.getoffer;

import com.up.lhm.getoffer.test.Be;
import com.up.lhm.getoffer.test.Ce;

/**
 * @author lianghaimiao
 * @date 2019/3/11
 * @function
 */

public class Tesxt {


    public static void main(String[] args) {
//        String a="hello";
//        String b="eorld";
//        String c="eorlw";
//        setdate(a,b,c);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
        Be be = new Be();
        Ce ce = new Ce();

        be.setName("dd");
        String name = ce.getName();
        System.out.println(name);

    }

    private static void setdate(String a, String b,String s) {
        a="2";
        b="4";
        s=s+"dd";
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
