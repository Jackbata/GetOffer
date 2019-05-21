package com.example.compon.designpattern.creational.factorys.fatcorymethod;

/**
 * @author lianghaimiao
 * @date 2019/5/21
 * @function
 */

public class AoidCarFactory implements ICarFactory {
    @Override
    public ICar createCar() {
       return new Aoidcar();
    }
}
