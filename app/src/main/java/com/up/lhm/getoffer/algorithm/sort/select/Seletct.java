package com.up.lhm.getoffer.algorithm.sort.select;

/**
 * @author lianghaimiao
 * @date 2020-04-01
 * @function
 */

public class Seletct implements IselectSort {
    @Override
    public int[] sort(int[] arr) {

        if(arr==null||arr.length==0){
            return arr;
        }

        for (int i = 0; i <arr.length-1 ; i++) {

            int index=i;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[index]>arr[j]){
                    index=j;
                }
            }
            if (index!=i){
                int temp =arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
            }
        }

        return arr;
    }
}
