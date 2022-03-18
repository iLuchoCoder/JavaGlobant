package com.globant.corzo.creationals.abstractFactory;

public class CarConfig {
    public static Car configureCar(String type) {

        Car car = null;
        CarFactory factory;
        if (type.equalsIgnoreCase("race")) {
            factory = new RaceCarFactory();
            car = new Car(factory);
        } else if (type.equalsIgnoreCase("family")) {
            factory = new FamilyCarFactory();
            car = new Car(factory);
        }
        return car;
    }
}
