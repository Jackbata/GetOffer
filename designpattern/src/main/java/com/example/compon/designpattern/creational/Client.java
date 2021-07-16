package com.example.compon.designpattern.creational;

import com.example.compon.designpattern.creational.chain.Chain1;
import com.example.compon.designpattern.creational.chain.Chain2;
import com.example.compon.designpattern.creational.chain.Chain3;
import com.example.compon.designpattern.creational.chain.IChain2;
import com.example.compon.designpattern.creational.chain.RealHandleChain;
import com.example.compon.designpattern.creational.observer.Observable;
import com.example.compon.designpattern.creational.observer.Observer1;
import com.example.compon.designpattern.creational.observer.Observer2;
import com.example.compon.designpattern.creational.observer.Observer3;
import com.example.compon.designpattern.creational.strategy.DoStrategy;
import com.example.compon.designpattern.creational.strategy.Strange1;
import com.example.compon.designpattern.creational.strategy.Strange2;
import com.example.compon.designpattern.creational.strategy.Strange3;
import com.example.compon.designpattern.creational.template.TemplateChild1;
import com.example.compon.designpattern.creational.template.TemplateChild2;
import java.util.ArrayList;

/**
 * @Description: 客户端
 * @Author: 肖邦
 * @CreateDate: 2021/7/14 5:50 PM
 */
public class Client {

  public static void main(String[] args) {
    //1.模版方法
    TemplateChild1 templateChild1 = new TemplateChild1();
    TemplateChild2 templateChild2 = new TemplateChild2();
    templateChild1.play();
    templateChild2.play();
  System.out.println("-------------------------------------");
    //2.责任链模式
    Chain1 chain1 = new Chain1();
    Chain2 chain2 = new Chain2();
    Chain3 chain3 = new Chain3();
    chain1.setNext(chain2);
    chain2.setNext(chain3);
    chain1.handle(1);

    //2.1 责任链模式变体(参考okhttp处理请求流程)
    System.out.println("-------------------------------");
    ArrayList<IChain2> list = new ArrayList<>();
    list.add(chain1);
    list.add(chain2);
    list.add(chain3);
    RealHandleChain realHandleChain = new RealHandleChain(0, list);
    realHandleChain.handle();

    //3.观察者模式
    System.out.println("-------------------------------");
    Observable observable = new Observable();
    Observer1 observer1 = new Observer1(observable);
    Observer2 observer2 = new Observer2(observable);
    Observer3 observer3 = new Observer3(observable);
    observable.setData(123);

    //4.策略模式
    DoStrategy doStrategy = new DoStrategy();
    doStrategy.setStrategy(new Strange1(),2,4);
    doStrategy.setStrategy(new Strange2(),2,4);
    doStrategy.setStrategy(new Strange3(),2,4);
  }
}
