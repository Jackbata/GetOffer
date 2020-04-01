package com.up.lhm.getoffer.algorithm.sort.exchange;

import com.up.lhm.getoffer.algorithm.sort.exchange.BubbSort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author lianghaimiao
 * @date 2020-03-31
 * @function
 */

public class NewSort {

    public static void main(String[] args) {
        int[] arr ={9,3,5,7,8,2,5,4,3,1,0,5};

//        BubbSort bubbSort = new BubbSort();
//        int[] sort = bubbSort.sort(arr);
//        System.out.println(Arrays.toString(sort));
        QuickSort quickSort = new QuickSort();
        int[] sort = quickSort.sort(arr);
        System.out.println(Arrays.toString(sort));
    }

}
