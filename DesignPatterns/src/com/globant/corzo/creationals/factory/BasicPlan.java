package com.globant.corzo.creationals.factory;

class BasicPlan implements Plan {

    private static final float rate = 1.05f;
    @Override
    public float getRate() {
        return rate;
    }
    @Override
    public float getTotal(int months) {
        return rate * months;
    }
}
