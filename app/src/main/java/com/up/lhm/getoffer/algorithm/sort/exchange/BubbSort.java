package com.up.lhm.getoffer.algorithm.sort.exchange;

/**
 * @author lianghaimiao
 * @date 2020-03-31
 * @function 冒泡排序
 */

public class BubbSort implements IExchange {


    @Override
    public int[] sort(int[] arr) {

        if(arr==null||arr.length==0){
            return arr;
        }

        bubbsort(arr);

        return arr;
    }

    private void bubbsort(int[] arr) {

        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i; j < arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }

            }



        }
    }
}
