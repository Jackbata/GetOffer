package com.example.compon.designpattern.creational.singleton;

/**
 * @Description: 懒汉式
 * @Author: 肖邦
 * @CreateDate: 2021/7/14 2:30 PM
 */
public class SingletonL {

  private SingletonL(){}

  private static SingletonL instance=null;
  public static SingletonL getInstance(){
    if (instance==null){
      instance=new SingletonL();
    }
    return instance;
  }

  //双重锁检查
  static class SingletonDcl{

    //volatile禁止指令重排
    private static volatile SingletonDcl instance=null;
    private SingletonDcl(){}
    public static SingletonDcl getInstance(){
      if(instance==null){//避免多线程获取锁时阻塞
        synchronized(SingletonDcl.class){
          if (instance==null){//避免多线程多次初始化
            instance=new SingletonDcl();
          }
        }
      }
      return instance;
    }
  }

  //静态单例
  static class SingletonLe{

    private SingletonLe(){}
    public static SingletonLe getInstance(){
      return INSTANCE.instance;
    }

     static class INSTANCE{
      private INSTANCE(){}
      private static final SingletonLe instance=new SingletonLe();
     }
  }
}
