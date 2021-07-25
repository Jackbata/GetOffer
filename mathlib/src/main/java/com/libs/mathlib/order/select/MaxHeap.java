package com.libs.mathlib.order.select;

import com.libs.mathlib.order.BaseOrder;

/**
 * @Description:堆排
 * @Author: 肖邦
 * @CreateDate: 2021/7/17 10:54 PM
 */
public class MaxHeap extends BaseOrder {

  @Override
  protected void start(int[] tree) {
    if(tree==null ||tree.length==0){
      return ;
    }

    int length = tree.length;
    for (int i = length/2-1; i >=0 ; i--) {
      buildMaxHeap(tree,length,i);
    }
    for (int i = length-1; i>0; i--) {
         swap(tree,0,i);
         buildMaxHeap(tree,i,0);
    }
  }

  private void buildMaxHeap(int[] tree, int length, int i) {
    int left=2*i+1;
    int right=2*i+2;
    int max=i;
    //大顶堆
    if (length>left&&tree[left]>tree[max]){
      max=left;
    }

    if (length>right&&tree[right]>tree[max]){
      max=right;
    }
    //小顶堆
//    if (length>left&&tree[left]<tree[max]){
//      max=left;
//    }
//
//    if (length>right&&tree[right]<tree[max]){
//      max=right;
//    }
    if (i!=max){
      swap(tree,i,max);
      buildMaxHeap(tree,length,max);
    }
  }

  private void swap(int[] tree, int i, int max) {
    int temp=tree[max];
    tree[max]=tree[i];
    tree[i]=temp;
  }
}
