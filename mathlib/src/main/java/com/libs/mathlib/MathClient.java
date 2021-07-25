package com.libs.mathlib;

import com.libs.mathlib.check.Check2;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/17 8:06 PM
 */
public class MathClient {

  public static void main(String[] args) {

    int[] arr={4,3,2,5};


//    //1.冒泡
//    Bubbing baseOrder = new Bubbing();
//    baseOrder.startOrder(arr);

    //2.快排序
//    Quick quick = new Quick();
//    quick.startOrder(arr);

    //3.直接插入排序
//    justSelect justSelect = new justSelect();
//    justSelect.startOrder(arr);

//    //4.堆排序
//    MaxHeap maxHeap = new MaxHeap();
//    maxHeap.startOrder(arr);
//    //5.插入排序
//    Sert sert = new Sert();
//    sert.startOrder(arr);
    //6.希尔排序
//    XierSert xierSert = new XierSert();
//    xierSert.startOrder(arr);

    //7.二分查找
    Check2 check2 = new Check2();
    int index = check2.getIndex(arr, 9);
    System.out.println("Check2---"+index);
  }
}
