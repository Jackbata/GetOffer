package com.example.compon.designpattern.creational.template;

/**
 * @Description: 模版方法
 * @Author: 肖邦
 * @CreateDate: 2021/7/14 5:46 PM
 */
public abstract class TemplateAbstract {
String Tag=this.getClass().getSimpleName()+"--";
  public void play(){
    jump();
 if (night()) {
   sleep();
   
 }else {
   run();
   
 }
  }

  protected abstract void run();

  protected abstract void sleep();

  protected abstract boolean night();

  private void jump() {
    System.out.println("jump"+Tag);
  }

}
