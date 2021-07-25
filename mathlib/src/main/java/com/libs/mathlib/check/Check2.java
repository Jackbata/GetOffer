package com.libs.mathlib.check;

/**
 * @Description: 二分查找
 * @Author: 肖邦
 * @CreateDate: 2021/7/18 12:43 AM
 */
public class Check2 {

  public int getIndex(int[]arr,int value){
    int length = arr.length;
    int low=0;
    int high=length-1;
    while(low<=high){
      int mid=(low+high)/2;

      if (arr[mid]<value){
        low=mid+1;
      }else if(arr[mid]>value){
        high=mid-1;
      }else {
        return mid;
      }
    }
    return -1;
  }
}
