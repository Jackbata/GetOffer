package com.example.compon.designpattern.creational.factorys.abstractfatcory;

/**
 * @author lianghaimiao
 * @date 2019/5/21
 * @function
 */

public class ProduceA implements IProduceFactory {
    @Override
    public IMouse createMouse() {
        return new MouseA();
    }

    @Override
    public ICompute createCompute() {
        return new ComputeA();
    }
}
