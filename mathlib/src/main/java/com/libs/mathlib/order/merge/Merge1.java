package com.libs.mathlib.order.merge;

import com.libs.mathlib.order.BaseOrder;

/**
 * @Description: 归并排序
 * @Author: 肖邦
 * @CreateDate: 2021/8/25 11:02 PM
 */
public class Merge1  extends BaseOrder {

  private int[] arr;
  /**
   * 备份左边的序列用于合并
   */
  private int[] leftArr = new int[arr.length>>>1];
  @Override
  protected void start(int[] data) {
    arr = data;
    startSort(0,arr.length);
  }

  //1.将数组元素不断平均分割成2个子序列，知道不能分割成2个位置
  private void startSort(int begin, int end) {

    if (end-begin<2) return;
     int mid = (end-begin)>>>1;
     //[begin,end)
     startSort(begin,mid);
     //[mid,end)
     startSort(mid,end);

     merge(begin,mid,end);
  }


  //2.将分割后的两个子序列，排序后再合并
  private void merge(int begin, int mid, int end) {
    int la=0,le=mid-begin;//左边序列标记 基于leftArr
    int ra=mid,re=end;//右边序列标记 基于arr
    int ai=begin;//用于合并的标记

    for (int i = la; i < le; i++) {//拷贝左边的数组
         leftArr[i]=arr[i+begin];
    }

    while(la<le){//左边序列未合并结束才需要继续合并
      if(ra<re && (arr[ra]<leftArr[la])){//先判断右边，确保算法稳定性
        arr[ai++]=arr[ra++];
      }else {
        arr[ai++]=leftArr[la++];
      }
    }
  }
}
