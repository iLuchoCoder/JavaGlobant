package com.globant.corzo.creationals.abstractFactory;

public class RaceCarFactory implements CarFactory {

    @Override
    public Suspension createSuspension() {
        return new RaceCarSuspension();
    }

    @Override
    public Engine createEngine() {
        return new RaceCarEngine();
    }
}
