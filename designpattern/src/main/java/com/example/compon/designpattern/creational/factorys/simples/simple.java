package com.example.compon.designpattern.creational.factorys.simples;

/**
 * @author lianghaimiao
 * @date 2019/5/21
 * @function
 */

public class simple {

    public static void main(String[] args) {
        /**
         * 1.违背了开放封闭原则，每新建一个类就要修改工厂类
         * 2.
         */
        Icar car = CarFactory.createCar("aodi");
        car.myCar();

    }
}
