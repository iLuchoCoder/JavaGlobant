package com.globant.corzo.structural.adapter;


class Adapter {

    public static void main(String args[]) {
        {
            Movable fastCar = new FastCar();
            MovableAdapter fastCarKM = new MovableAdapterImpl(fastCar);

            System.out.println("Speed mph -> " + fastCar.getSpeed());
            System.out.println("Speed km/h -> " + fastCarKM.getSpeed());

        }
    }
}