package com.up.lhm.getoffer.algorithm.sort.select;

import java.util.Arrays;

/**
 * @author lianghaimiao
 * @date 2020-04-01
 * @function
 */

public class Selectsort {
    public static void main(String[] args) {
        int[] arr ={9,3,5,7,8,2,5,4,3,1,0,5};
        DumpSort seletct = new DumpSort();
        int[] sort = seletct.sort(arr);
        System.out.println(Arrays.toString(sort));
    }
}
