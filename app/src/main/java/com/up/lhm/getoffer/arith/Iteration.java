package com.up.lhm.getoffer.arith;

/**
 * @author lianghaimiao
 * @date 2019/4/9
 * @function
 */

public  class Iteration {

    public static void main(String[] args) {
        int step = getStep2(10);
        System.out.print("总共 " + step + " 中走法");
    }

    /**
     * 1.跳台阶---迭代法 f(n)=f(n-1)+f(n-2)
     * 一个台阶总共有n级，如果一次可以跳1级，也可以跳2级，求总共有多少种跳法。
     *
     * @param num 台阶数
     */
    private static int getStep(int num) {
        int result = 0;
        if (num == 1 || num == 2) {
            result = num;
        }

        int temp1 = 1;
        int temp2 = 2;
        for (int i = 3; i <= num; i++) {
            result = temp1 + temp2;
            temp1 = temp2;
            temp2 = result;
        }

        return result;
    }

    /**
     * 2.变态跳台阶---迭代法  f(n)=2*(n-1)
     * 一个台阶总共有n级，如果一次可以跳1级，也可以跳2级，求总共有多少种跳法。
     *
     * @param num 台阶数
     */
    private static int getStep2(int num) {
        int result = 0;
        if (num >= 2) {
            result = num;
        }
        result = 2 << (num - 2);
//        for (int i = 2; i <= num; i++) {
//            result = 2*temp1;
//            temp1 = result;
//        }

        return result;
    }

}
