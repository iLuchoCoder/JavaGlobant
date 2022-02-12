package com.globant.corzo.creationals.abstractFactory;

public class RaceCarSuspension implements Suspension {

    @Override
    public void createSuspension() {
        System.out.println("You have created RaceCarSuspension.");
    }
}
