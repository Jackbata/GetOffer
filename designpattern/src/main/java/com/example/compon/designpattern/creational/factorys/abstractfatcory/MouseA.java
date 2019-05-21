package com.example.compon.designpattern.creational.factorys.abstractfatcory;

/**
 * @author lianghaimiao
 * @date 2019/5/21
 * @function
 */

public class MouseA implements IMouse {
    @Override
    public void provideMouse() {
       System.out.print("MouseA");
    }
}
