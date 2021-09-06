package com.libs.mathlib.order;

/**
 * @Description: 计数排序 ：对一定范围的正数进行排序
 * @Author: 肖邦
 * @CreateDate: 2021/8/26 4:58 PM
 */
public class Count extends BaseOrder {

  @Override
  protected void start(int[] arr) {
    //1.获取数组最大最小值max、min
    int max=0;
    int min=0;
    for (int i = 1; i <arr.length ; i++) {
      if (arr[max]<arr[i]){
         max=i;
      }
      if (arr[min]>arr[i]){
        min=i;
      }
    }
    //2.创建计数数组length=max-min+1，设置待排序元素在计数数组中的索引位置=元素-min ，元素出现次数：++  ，加上上一个元素出现的次数
    //3.创建排序数组 length=原始数组length
    //4.从右向左遍历原数组元素，根据计数数组中的位置，获取在排序数组中的位置 index=元素-min-1  计数索引元素-1



  }
}