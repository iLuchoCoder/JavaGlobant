package com.globant.corzo.creationals.factory;

class FullPlan implements Plan {
    private static final float rate = 1.85f;

    @Override
    public float getRate() {
        return rate;
    }

    @Override
    public float getTotal(int months) {
        return rate * months;
    }
}
