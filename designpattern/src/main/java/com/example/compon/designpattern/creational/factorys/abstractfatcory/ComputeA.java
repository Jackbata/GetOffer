package com.example.compon.designpattern.creational.factorys.abstractfatcory;

/**
 * @author lianghaimiao
 * @date 2019/5/21
 * @function
 */

public class ComputeA implements ICompute {
    @Override
    public void provideCompute() {
        System.out.print("ComputeA");
    }
}
