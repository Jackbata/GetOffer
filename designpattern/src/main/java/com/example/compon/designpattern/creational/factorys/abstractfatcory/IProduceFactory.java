package com.example.compon.designpattern.creational.factorys.abstractfatcory;

/**
 * @author lianghaimiao
 * @date 2019/5/21
 * @function 不同产品族工厂
 */

public interface IProduceFactory {

    IMouse createMouse();

    ICompute createCompute();
}
