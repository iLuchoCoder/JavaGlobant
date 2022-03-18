package com.globant.corzo.creationals.abstractFactory;

public interface CarFactory {
    Suspension createSuspension();

    Engine createEngine();
}
