package com.example.compon.designpattern.creational.chain;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/15 2:54 PM
 */
 public abstract class AbstractChain {

 String Tag = this.getClass().getSimpleName()+"--";
  private AbstractChain mChain;

  public void setNext(AbstractChain chain){
   mChain=chain;
  }

  public void handle(int num){
   doProcess(num);
   num++;
   if (mChain!=null){
      mChain.handle(num);
   }
  }

 protected abstract void doProcess(int num);
}
