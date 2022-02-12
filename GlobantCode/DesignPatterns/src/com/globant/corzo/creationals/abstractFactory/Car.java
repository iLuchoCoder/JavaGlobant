package com.globant.corzo.creationals.abstractFactory;

public class Car {
    private Suspension suspension;
    private Engine engine;

    public Car(CarFactory factory) {
        suspension = factory.createSuspension();
        engine = factory.createEngine();
    }

    public void createCar() {
        suspension.createSuspension();
        engine.createEngine();
    }
}
