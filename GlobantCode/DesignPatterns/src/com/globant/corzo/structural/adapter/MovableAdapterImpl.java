package com.globant.corzo.structural.adapter;

public class MovableAdapterImpl implements MovableAdapter {
    private Movable car;

    public MovableAdapterImpl(Movable fastCar) {
        car = fastCar;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(car.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}
