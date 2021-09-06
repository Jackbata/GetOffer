package com.libs.mathlib.order.swap;

import com.libs.mathlib.order.BaseOrder;

/**
 * @Description：快速排序
 * @Author: 肖邦
 * @CreateDate: 2021/7/17 8:41 PM
 */
public class Quick extends BaseOrder {

  @Override
  protected void start(int[] arr) {
    int length=arr.length;
    int low=0;
    int high=length-1;
    getQuikc(arr,low,high);
  }

  private void getQuikc(int[] arr, int low, int high) {
   if (low<high){
     int index=getIndex(arr,low,high);
     getQuikc(arr,0,index-1);
     getQuikc(arr,index+1,high);
   }
  }

  private int getIndex(int[] arr, int low, int high) {
    int temp=arr[low];

    while (low<high){
      while (low<high&&arr[high]>=temp) high--;
      if (low<high) arr[low]=arr[high];
      while (low<high&&arr[low]<=temp) low++;
      if (low<high) arr[high]=arr[low];
    }
    arr[low]=temp;
    return low;
  }
}
