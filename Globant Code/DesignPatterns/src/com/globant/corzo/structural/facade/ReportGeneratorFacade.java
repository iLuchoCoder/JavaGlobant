package com.globant.corzo.structural.facade;

import javax.activation.DataSource;
import java.util.Objects;

public class ReportGeneratorFacade {
    public void generateReport(ReportType type, String location) {
        Report report = new Report();

        report.setHeader(new ReportHeader());
        report.setFooter(new ReportFooter());


        report.setData(new ReportData());

        ReportWriter writer = new ReportWriter();
        switch (Objects.requireNonNull(type)) {
            case HTML:
                writer.writeHtmlReport(report, location);
                break;

            case PDF:
                writer.writePdfReport(report, location);
                break;
        }
    }
}
