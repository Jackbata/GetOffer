package com.up.lhm.getoffer.algorithm.sort.insert;

/**
 * @author lianghaimiao
 * @date 2020-04-01
 * @function
 */

public class ShellSort implements Iinsert {
    @Override
    public void sort(int[] arr) {
        if(arr==null||arr.length==0){
            return ;
        }

        int cap=arr.length;
        //间隔数
        for (int i = cap/2; i >0 ; i/=2) {

            //无序部分
            for (int j = i; j <cap ; j++) {
                //有序部分
                int temp =arr[j];
                int index=j;
                for (int k = j-i; k >=0; k-=i) {

                    if(temp<arr[k]){
                     arr[index]=arr[k];
                     index=k;
                    }
                }
                    arr[index]=temp;
            }
        }
    }
}
