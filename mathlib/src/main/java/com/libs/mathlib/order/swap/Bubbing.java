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
//    for (int i = 0; i < length-1; i++) {
//      for (int j = 0; j < length-1-i; j++) {
//
//        if (data[j]>data[j+1]){
//          int temp = data[j+1];
//          data[j]=data[j+1];
//          data[j]=temp;
//        }
//
//      }
//    }
//    2 4 5 6 7  length=5  index=0...4


    //优化后:
    //3.确认交换总次数 length-1（首个位置元素不用参与交换）,倒序遍历
    for (int i = length-1; i>0 ; i--) {
       int endIndex=1;
      //1.交换步骤：获取后面值后，再前面值比较
      //2.确定【交换的索引范围】 1...length-1 ，每次完成交换减一
      for (int j = 1; j <= i; j++) {
        if (data[j]<data[j-1]){
          int temp = data[j];
          data[j]=data[j-1];
          data[j-1]=temp;
          //记录上次最后一个索引
          endIndex=j;
        }
      }
      i=endIndex;
    }


  }
}
