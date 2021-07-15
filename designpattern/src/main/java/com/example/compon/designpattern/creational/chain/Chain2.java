package com.example.compon.designpattern.creational.chain;

import com.example.compon.designpattern.creational.factorys.simples.Icar;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/15 3:02 PM
 */
public class Chain2 extends AbstractChain implements IChain2 {

  @Override
  protected void doProcess(int num) {
    System.out.println(Tag+num);
  }

  @Override
  public void doProcess2(int num, RealHandleChain nextHandleChain) {
    System.out.println(Tag+num);
    nextHandleChain.handle();
  }
}
