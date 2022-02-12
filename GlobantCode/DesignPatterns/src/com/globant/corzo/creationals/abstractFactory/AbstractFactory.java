package com.globant.corzo.creationals.abstractFactory;

public class AbstractFactory {
    public static void main(String[] args) {

        Car car = CarConfig.configureCar("race");
        car.createCar();

        Car car1 = CarConfig.configureCar("family");
        car1.createCar();
    }
}

