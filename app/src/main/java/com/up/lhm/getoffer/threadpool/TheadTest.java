package com.up.lhm.getoffer.threadpool;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import com.up.lhm.getoffer.Tesxt;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/21 11:49 AM
 */
public class TheadTest {


  public static void main(String[] args) {
    Thread thread1 = new MyThread();
    thread1.setName("thread1");
    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        int id = ((MyThread) thread1).getInt3();

        System.out.println("thread2=" +  Thread.currentThread().getName()+" id="+id);

      }
    });
    thread2.setName("thread2");
    thread1.start();
    int id = ((MyThread) thread1).getInt3();
    System.out.println("ui"+Thread.currentThread().getName()+"id="+id);
  }



}
class MyThread extends Thread{
  int a=0;
  public Tesxt ta=new Tesxt();
  @Override
  public void run() {
    try {
      sleep(3000);
      synchronized (this){
        a=11;
        String simpleName = this.getClass().getSimpleName();

        System.out.println("MyThread"+this.getName()+" a="+a+simpleName);
        notifyAll();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }


  public int getInt3(){
    synchronized (this){
      String simpleName = this.getClass().getSimpleName();
      if (a==0){
        try {
          System.out.println("getInt3"+Thread.currentThread().getName()+" a="+a);

          System.out.println("MyThread"+this.getName()+" a="+a+simpleName);
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    return a;
  }
}