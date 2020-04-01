package com.up.lhm.getoffer.algorithm.sort.insert;

/**
 * @author lianghaimiao
 * @date 2020-04-01
 * @function
 */

public class InsertSort implements Iinsert {
    @Override
    public void sort(int[] arr) {
        if(arr==null||arr.length==0){
            return;
        }

        for (int i = 1; i <arr.length ; i++) {

            int temp=arr[i];
            int index=i;
            for (int j = i-1; j >=0 ; j--) {
                if(temp<arr[j]){
                    arr[index]=arr[j];
                    index=j;
                }
            }
            arr[index]=temp;
        }
    }
}
