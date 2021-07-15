package com.example.compon.designpattern.creational.chain;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/15 4:02 PM
 */
public interface IChain2 {

  void doProcess2(int num, RealHandleChain nextHandleChain);

  interface IHandleChain{
    void handle();
  }
}
