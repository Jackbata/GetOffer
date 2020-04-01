package com.up.lhm.getoffer.algorithm.sort.exchange;

/**
 * @author lianghaimiao
 * @date 2020-03-31
 * @function
 */

public class QuickSort implements IExchange{
    @Override
    public int[] sort(int[] arr) {
        if(arr==null||arr.length==0){
            return arr;
        }

        quicksort(arr,0,arr.length-1);

        return arr;
    }

    private void quicksort(int[] arr, int low, int high) {

        if(low<high){
            int index = getIndex(arr, low, high);
            quicksort(arr,0,index-1);
            quicksort(arr,index+1,high);
        }


    }

    private int getIndex(int[] arr, int low, int high) {
        int temp =arr[low];

        while(low<high){
            while(low<high && arr[high]>=temp) high--;
            if (low<high){
                arr[low]=arr[high];
            }

            while(low<high && arr[low]<=temp) low++;
            if (low<high){
                arr[high]=arr[low];
            }
        }
        arr[low]=temp;
      return low;
    }
}
