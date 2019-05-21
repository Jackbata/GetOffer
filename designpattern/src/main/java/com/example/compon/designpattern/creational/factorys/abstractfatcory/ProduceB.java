package com.example.compon.designpattern.creational.factorys.abstractfatcory;

/**
 * @author lianghaimiao
 * @date 2019/5/21
 * @function
 */

public class ProduceB implements IProduceFactory {
    @Override
    public IMouse createMouse() {
        return new MouseB();
    }

    @Override
    public ICompute createCompute() {
        return new ComputeB();
    }
}
