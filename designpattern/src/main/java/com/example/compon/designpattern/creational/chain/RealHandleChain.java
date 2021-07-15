package com.example.compon.designpattern.creational.chain;

import com.example.compon.designpattern.creational.chain.IChain2.IHandleChain;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 肖邦
 * @CreateDate: 2021/7/15 4:03 PM
 */
public class RealHandleChain implements IHandleChain {

  private List<IChain2> list= new ArrayList<>();

 private int curIndex=0;


 public RealHandleChain(int index,List chaiList){
   curIndex=index;
   list=chaiList;
 }
  @Override
  public void handle() {
      if (curIndex<list.size())
      {
        IChain2 chain =list.get(curIndex);
        RealHandleChain nextHandleChain = new RealHandleChain(curIndex + 1, list);
        chain.doProcess2(curIndex,nextHandleChain);
      }else {
        System.out.println("处理结束");
      }
  }
}
