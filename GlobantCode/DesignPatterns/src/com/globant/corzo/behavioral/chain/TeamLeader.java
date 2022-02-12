package com.globant.corzo.behavioral.chain;

public class TeamLeader extends LeaveHandler {

    @Override
    public String applyLeave(Leave leave) {

        if (leave.getNumberOfDays() <= 7) {
            if (leave.getEmpTier() <= 4) {
                return "Your leave days has been APPROVED by TeamLeader";
            } else {
                return "You employee Tier level is too low for request " + leave.getNumberOfDays() + " days";
            }
        } else {
            return superVisor.applyLeave(leave);
        }
    }
}

