package com.example.compon.designpattern.creational.observer;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/15 6:40 PM
 */
public class Observer3 implements IObserver {

  public Observer3(Observable observable){
    observable.subscribe(this);
  }
  @Override
  public void update(int num) {
    System.out.println("Observer3:"+num);
  }
}
