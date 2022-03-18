package com.globant.corzo.creationals.abstractFactory;

public class FamilyCarSuspension implements Suspension {

    @Override
    public void createSuspension() {
        System.out.println("You have created FamilyCarSuspension.");
    }
}
