package com.globant.corzo.behavioral.chain;

import java.io.IOException;

class Chain {

    public static void main(String args[]) throws IOException {

        TeamLeader teamLeader = new TeamLeader();
        ProjectLeader projectLeader = new ProjectLeader();
        HR hr = new HR();
        Manager manager = new Manager();

        teamLeader.setSuperVisor(projectLeader);
        projectLeader.setSuperVisor(hr);
        hr.setSuperVisor(manager);

        Leave leave1 = new Leave(5,4, ReasonType.REGULAR);
        System.out.println(teamLeader.applyLeave(leave1));

        Leave leave2 = new Leave(18,2, ReasonType.REGULAR);
        System.out.println(teamLeader.applyLeave(leave2));
    }
}

