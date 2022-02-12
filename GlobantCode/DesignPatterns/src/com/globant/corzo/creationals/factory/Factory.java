package com.globant.corzo.creationals.factory;

class Factory {

    public static void main(String args[]) {

        GetPlanFactory planFactory = new GetPlanFactory();

        Plan basic = planFactory.getPlan("BASIC");
        System.out.println("Plan rate: " + basic.getRate() + " - Total 12 months: " + basic.getTotal(12));

        Plan medium = planFactory.getPlan("MEDIUM");
        System.out.println("Plan rate: " + medium.getRate() + " - Total 12 months: " + medium.getTotal(12));

        Plan full = planFactory.getPlan("FULL");
        System.out.println("Plan rate: " + full.getRate() + " - Total 12 months: " + full.getTotal(12));


    }
}
