package com.example.compon.designpattern.creational.template;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/14 5:49 PM
 */
public class TemplateChild1 extends TemplateAbstract{

  @Override
  protected void run() {
    System.out.println("run"+Tag);

  }

  @Override
  protected void sleep() {
    System.out.println("sleep"+Tag);

  }

  @Override
  protected boolean night() {
    return false;
  }
}
