package com.example.compon.designpattern.creational.strategy;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/16 10:48 AM
 */
public class DoStrategy {

  public void setStrategy(IStrategy strategy,int num1,int num2){
    int i = strategy.doProcess(num1, num2);
    System.out.println("i="+i+"，strategy="+strategy.getClass().getSimpleName());
  }

}
