package com.globant.corzo.creationals.prototype;

public class NasaSpaceShip extends SpaceShip {

    private String name;

    public NasaSpaceShip(double mass, double height) {
        super(mass, height);
        this.name = "Nasa";
    }

    public String getName() {
        return name;
    }

        @Override
    public SpaceShip copy() {
        NasaSpaceShip plasticTreeClone = new NasaSpaceShip(this.getMass(), this.getHeight());
        plasticTreeClone.setPosition(this.getPosition());
        return plasticTreeClone;
    }



}
