package com.example.compon.designpattern.creational.factorys.abstractfatcory;

/**
 * @author lianghaimiao
 * @date 2019/5/21
 * @function
 */

public class AbstractProde {
    public static void main(String[] args) {
        IProduceFactory produceA = new ProduceA();
        produceA.createCompute().provideCompute();
        produceA.createMouse().provideMouse();
    }
}
