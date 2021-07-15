package com.example.compon.designpattern.creational.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 被观察者
 * @Author: 肖邦
 * @CreateDate: 2021/7/15 6:38 PM
 */
public class Observable {

private List<IObserver> list= new ArrayList<>();


  public void subscribe(IObserver observer){
    list.add(observer);
  }

  public void unSubscribe(IObserver observer){
    list.remove(observer);
  }

  public void setData(int num){
    System.out.println("Observable"+num);
    for (IObserver observer:list) {
      observer.update(num);
    }
  }
}
