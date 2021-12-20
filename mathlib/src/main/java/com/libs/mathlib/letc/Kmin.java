package com.libs.mathlib.letc;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/10/21 12:18 PM
 */
public class Kmin {

  public static void main(String[] args) {
    int[] arr ={1,3,5,7,2,4,6,8};
    int[] ints = smallestK(arr, 4);

    print(ints,"结果");
  }

  private static  void print(int[] ints,String log) {

    for (int i = 0; i < ints.length; i++) {
      System.out.print(ints[i]);
    }
    System.out.println("---"+log+"--------");

  }

  public static int[] smallestK(int[] arr, int k) {

    int[] arrk = new int[k];
    if(k==0) return arrk;

    if(arr.length<=k)

    {return arr;}

    for(int i=0;i<k;i++){
      arrk[i]=arr[i];
    }
    print(arrk,"初始值");
    heapSort(arrk);
    print(arrk,"第一次排序");
    for(int i=k;i<arr.length;i++){
      System.out.println("k="+i+"arr="+arr[i]);
      if(arr[i]<arrk[0]){
        arrk[0]=arr[i];
        heapSort(arrk);
//        buildHeap(arr,0,k);
        print(arrk,"开始遍历"+i);
      }
    }


    return arrk;


  }
  public static void heapSort(int[] arr){
    int length = arr.length;
    for(int i = length/2-1;i>=0;i--){
      buildHeap(arr,i,length);
    }

//    for(int i =length-1;i>0;i--){
//      swip(arr,i,0);
//      buildHeap(arr,0,i);
//    }
  }
  public static void buildHeap(int[] arr, int i, int length){
    int max=i;
    int left=2*i+1;
    int right=2*i+2;
    if(left<length&&arr[max]<arr[left]) max=left;
    if(right<length&&arr[max]<arr[right]) max=right;
    if(max!=i){
      swip(arr,i,max);
      buildHeap(arr,max,length);
    }
  }
  public static void swip(int[] arr, int num1, int num2){
    int temp = arr[num1];
    arr[num1]=arr[num2];
    arr[num2]=temp;
  }
}
