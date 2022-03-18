package com.globant.corzo.creationals.prototype;

public class Prototype {
    public static void main(String args[]) {
        double mass = 10.0;
        double height = 3.7;
        Position position1 = new Position(3, 7);
        Position position2 = new Position(4, 8);

        NasaSpaceShip nasaSpaceShip = new NasaSpaceShip(mass, height);
        nasaSpaceShip.setPosition(position1);

        System.out.println("nasaSpaceShip position:" + nasaSpaceShip.getPosition());

        NasaSpaceShip nasaSpaceShip1 = (NasaSpaceShip) nasaSpaceShip.copy();
        System.out.println("nasaSpaceShip1 position after clone:" + nasaSpaceShip1.getPosition());
        nasaSpaceShip1.setPosition(position2);
        System.out.println("nasaSpaceShip1 position after change position:" + nasaSpaceShip1.getPosition());

    }
}

