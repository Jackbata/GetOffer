package com.example.compon.designpattern.creational.singleton;

/**
 * @Description:
 * @Author: 肖邦 饿汉式
 * @CreateDate: 2021/7/14 2:27 PM
 */
public class SingletonE {

  private SingletonE(){
  }
  //空间换时间
  private static final SingletonE instance=new SingletonE();
  public static SingletonE getInstance(){
    return instance;
  }
}
