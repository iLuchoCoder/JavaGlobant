package com.globant.corzo.creationals.factory;

class MediumPlan implements Plan {

    private static final float rate = 1.45f;

    @Override
    public float getRate() {
        return rate;
    }

    @Override
    public float getTotal(int months) {
        return rate * months;
    }
}
