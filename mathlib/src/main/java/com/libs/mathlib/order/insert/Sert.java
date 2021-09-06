package com.libs.mathlib.order.insert;

import com.libs.mathlib.order.BaseOrder;

/**
 * @Description:插入排序
 * @Author: 肖邦
 * @CreateDate: 2021/7/17 11:55 PM
 */
public class Sert extends BaseOrder {

  @Override
  protected void start(int[] arr) {
    int length = arr.length;
//    for (int i = 1; i <length ; i++) {
//         int temp=arr[i];
//         int j=i;
//         if (temp<arr[i-1]){
//           while(j>=1&&temp<arr[j-1]){
//             arr[j]=arr[j-1];
//             j--;
//           }
//         }
//         arr[j]=temp;
//    }


    for (int i = 1; i < length; i++) {
      int temp=arr[i];
      int j=i;
      if (arr[j]<=temp){
        while (j>=1&&temp>=arr[j-1]){
          arr[j]=arr[j-1];
          j--;
        }
      }
      arr[j]=temp;
    }
  }
}
