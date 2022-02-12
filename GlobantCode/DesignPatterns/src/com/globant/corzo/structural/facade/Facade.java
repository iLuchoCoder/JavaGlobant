package com.globant.corzo.structural.facade;


import com.globant.corzo.structural.proxy.Internet;
import com.globant.corzo.structural.proxy.ProxyInternet;

class Facade {

    public static void main(String args[]) {
        {
            ReportGeneratorFacade reportGeneratorFacade = new ReportGeneratorFacade();

            reportGeneratorFacade.generateReport(ReportType.HTML, null);

            reportGeneratorFacade.generateReport(ReportType.PDF, null);
        }
    }
}


