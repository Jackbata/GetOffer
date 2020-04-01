package com.up.lhm.getoffer.algorithm.sort.select;

/**
 * @author lianghaimiao
 * @date 2020-04-01
 * @function
 */

public class DumpSort  implements IselectSort{
    @Override
    public int[] sort(int[] arr) {
        if(arr==null||arr.length==0){
            return arr;
        }

        for (int i = arr.length/2-1; i >=0 ; i--) {
            buildDump(arr,arr.length,i);
        }
        for (int i = arr.length-1; i >0 ; i--) {
            swip(arr,i,0);
            buildDump(arr,i,0);
        }

        return arr;
    }

    private void buildDump(int[] arr, int length, int i) {

        int left = 2*i+1;
        int right=2*i+2;
        int max=i;

        if(left<length&&arr[left]>arr[max]){
           max= left;
        }
        if (right<length&&arr[right]>arr[max]){
            max=right;
        }

        if(max!=i){
            swip(arr,max,i);
            buildDump(arr,length,max);
        }
    }

    private void swip(int[] arr, int end, int start) {
        int temp=arr[end];
        arr[end]=arr[start];
        arr[start]=temp;
    }
}
