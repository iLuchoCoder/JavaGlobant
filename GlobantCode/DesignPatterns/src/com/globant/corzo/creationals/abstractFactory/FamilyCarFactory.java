package com.globant.corzo.creationals.abstractFactory;

public class FamilyCarFactory implements CarFactory {

    @Override
    public Suspension createSuspension() {
        return new FamilyCarSuspension();
    }

    @Override
    public Engine createEngine() {
        return new FamilyCarEngine();
    }
}
