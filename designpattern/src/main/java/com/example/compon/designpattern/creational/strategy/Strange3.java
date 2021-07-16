package com.example.compon.designpattern.creational.strategy;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/16 10:47 AM
 */
public class Strange3 implements IStrategy {

  @Override
  public int doProcess(int num1, int num2) {
    return num1*num2;
  }

}
