package com.libs.mathlib.order.swap;

import com.libs.mathlib.order.BaseOrder;
import java.util.Arrays;

/**
 * @Description:冒泡排序
 * @Author: 肖邦
 * @CreateDate: 2021/7/17 8:07 PM
 */
public class Bubbing extends BaseOrder {

  public  void start(int[] data) {
    //2 4 5
    int length=data.length;
//    for (int i = 0; i < length-1 ; i++) {
//      for (int j = i+1; j <length ; j++) {
//           if (data[i]>data[j]){
//              int temp=data[i];
//              data[i]=data[j];
//              data[j]=temp;
//           }
//      }
//    }

    for (int i = 0; i <length-1 ; i++) {
      for (int j = 0; j <length-1-i ; j++) {

        if (data[j]>data[j+1]){
          int temp=data[j+1];
          data[j+1]=data[j];
          data[j]=temp;
        }
      }
    }
  }
}
