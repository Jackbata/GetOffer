package com.libs.mathlib.order.insert;

import com.libs.mathlib.order.BaseOrder;

/**
 * @Description: 希尔排序
 * @Author: 肖邦
 * @CreateDate: 2021/7/18 12:22 AM
 */
public class XierSert extends BaseOrder {

  @Override
  protected void start(int[] arr) {
    int length = arr.length;
    for (int i =length/2 ; i >=1 ; i/=2) {
      sert(arr, length, i);
    }
  }

  private void sert(int[] arr, int length, int i) {
    for (int j = i; j <length ; j++) {
      int temp=arr[j];
      int s=j;
      while(s>=i&&temp<arr[s-i]){
        arr[s]=arr[s-i];
        s-=i;
      }
      arr[s]=temp;
    }
  }
}
