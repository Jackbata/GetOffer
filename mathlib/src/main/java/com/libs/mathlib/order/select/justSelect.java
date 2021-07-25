package com.libs.mathlib.order.select;

import com.libs.mathlib.order.BaseOrder;

/**
 * @Description：直接选择
 * @Author: 肖邦
 * @CreateDate: 2021/7/17 8:41 PM
 */
public class justSelect extends BaseOrder {

  @Override
  protected void start(int[] arr) {
    int length=arr.length;
    for (int i = 0; i < length-1; i++) {
      for (int j = i+1; j < length; j++) {
        if (arr[i]<arr[j]){
          int temp=arr[i];
          arr[i]=arr[j];
          arr[j]=temp;
        }

      }
    }
    //优化
//    for (int i = 0; i < length-1; i++) {
//      int minIndex=i;
//      for (int j = i+1; j < length; j++) {
//        if (arr[minIndex]>arr[j]){
//          minIndex=j;
//        }
//      }
//      if (minIndex!=i){
//        swip(arr,i,minIndex);
//      }
//    }
  }

  private void swip(int[] arr, int i, int j) {
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }

}
