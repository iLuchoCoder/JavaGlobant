package com.globant.corzo.creationals.factory;

class GetPlanFactory {

    public Plan getPlan(String planType) {

        if (planType == null) {
            return null;
        }

        if (planType.equalsIgnoreCase("BASIC")) {
            return new BasicPlan();
        } else if (planType.equalsIgnoreCase("MEDIUM")) {
            return new MediumPlan();
        } else if (planType.equalsIgnoreCase("FULL")) {
            return new FullPlan();
        }

        return null;
    }
}
