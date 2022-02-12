package com.globant.corzo.behavioral.chain;

public class ProjectLeader extends LeaveHandler {

    @Override
    public String applyLeave(Leave leave) {

        if (leave.getNumberOfDays() <= 14) {
            if (leave.getEmpTier() <= 3) {
                return "Your leave days has been APPROVED by Project Leader";
            } else {
                return "You employee Tier level is too low for request " + leave.getNumberOfDays() + " days";
            }
        } else {
            return superVisor.applyLeave(leave);
        }
    }
}

