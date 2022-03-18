package com.globant.corzo.creationals.singleton;

public class Sun {

    private static Sun singleInstance;

    private Sun() {
    }

    public void shine() {
        System.out.println("Light everywhere aksjdhsakj..");
    }

    public static Sun getInstance() {

        if (singleInstance == null) {
            singleInstance = new Sun();
        }

        return singleInstance;
    }
}
