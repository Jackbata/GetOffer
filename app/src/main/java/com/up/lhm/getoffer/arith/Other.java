package com.up.lhm.getoffer.arith;

/**
 * @author lianghaimiao
 * @date 2019/4/22
 * @function
 */

public class Other {
    public static void main(String[] args) {
        int n = 12345678;

        int a = getInt(n);
        System.out.println(a);
    }

    /**
     * 取一个整数a从右端开始的4～7位
     */
    private static int getInt(int n) {
        if (n == 0) {
            return -1;
        }
        String d = n + "";

        int length = d.length();
        if (d.length() >= 7) {
            String substring = d.substring(length - 7, length - 3);
            int i = Integer.parseInt(substring);
            return i;
        }
        return -1;
    }

}
