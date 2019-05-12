package com.up.lhm.getoffer.arith;

import android.util.Log;

/**
 * @author lianghaimiao
 * @date 2019/4/8
 * @function 排序
 */

public class Sort {

    public static void main(String[] args) {

//        //排序
//        int[] arr = {6, 4, 33, 5,33,44,3,2,4,1,1,0};
////        bubbleSort(arr);
//
//        quickSort(arr, 0, arr.length - 1);
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.print(arr[i]+"--");
//        }

        System.out.println((~10)+1);
    }

    /**
     * 3.快速排序--挖坑填数+分治
     *
     * 选第一位为基准数，然后从右边开始比较，小于基准的放到左边，之后从左边开始判断，大于基准的放右边；
     * 之后分别对左右两边重复上述步骤
     */
    private static void quickSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;
        int index = arr[low];

        while (end > start) {

            while (arr[end] > index && end > start) {
                end--;
            }
            if (end > start) {
                arr[start++]=arr[end];
            }
            while (arr[start] < index && end > start) {
                start++;
            }
            if (end>start){
                arr[end--]=arr[start];
            }

        }
        arr[end] = index;
        quickSort(arr, low, start - 1);
        quickSort(arr, end + 1, high);
    }

    /**
     * 1.冒泡排序
     * 相邻元素两两比较，大的往后放，第一次完毕最大值出现在了最大索引处
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        int length = arr.length - 1;
        int temp = 0;
        boolean change = false;
        //比较几轮
        for (int i = 0; i < length; i++) {
            change = false;
            //每轮有几组进行比较
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    change = true;
                }
            }
            if (!change) {
                //如果一轮循环过后无位置改变，表明已经排序完成
                break;
            }
        }

    }

    /**
     * 2.选择排序
     * 两个数比较大小，较大的数下沉，较小的数冒起来。
     */
    private static void selectSort(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        int length = arr.length;
        int temp = 0;
        for (int i = 0; i < length - 1; i++) {

            for (int j = i + 1; j < length; j++) {

                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }


}
