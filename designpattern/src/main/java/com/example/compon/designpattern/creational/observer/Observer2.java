package com.example.compon.designpattern.creational.observer;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/15 6:40 PM
 */
public class Observer2 implements IObserver {

  public Observer2(Observable observable){
    observable.subscribe(this);
  }
  @Override
  public void update(int num) {
    System.out.println("Observer2:"+num);
  }
}
