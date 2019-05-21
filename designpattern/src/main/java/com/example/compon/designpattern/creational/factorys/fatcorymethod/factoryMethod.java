package com.example.compon.designpattern.creational.factorys.fatcorymethod;

/**
 * @author lianghaimiao
 * @date 2019/5/21
 * @function
 */

public class factoryMethod {

    public static void main(String[] args) {
        ICarFactory aoidCarFactory = new AoidCarFactory();
        aoidCarFactory.createCar().myCar();
    }
}
