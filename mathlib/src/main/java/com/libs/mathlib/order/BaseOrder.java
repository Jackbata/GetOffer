package com.libs.mathlib.order;


import java.util.Arrays;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/17 8:42 PM
 */
public abstract class BaseOrder {
  String Tag=this.getClass().getSimpleName();

  public void startOrder(int[] arr){
    start(arr);
    System.out.println(Tag+": "+ Arrays.toString(arr));
  }
  protected abstract  void start(int[] arr);

}
