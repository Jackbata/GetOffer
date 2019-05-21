package com.example.compon.designpattern.creational.factorys.simples;

/**
 * @author lianghaimiao
 * @date 2019/5/21
 * @function
 */

public class CarFactory {

    public static Icar createCar(String type) {
        Icar car = null;
        switch (type) {
            case "aodi":
                car = new Aodi();
                break;
            case "benchi":
                car = new Benchi();
                break;
            default:
                break;

        }
        return car;
    }

}

