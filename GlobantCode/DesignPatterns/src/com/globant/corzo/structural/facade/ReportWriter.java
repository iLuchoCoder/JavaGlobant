package com.globant.corzo.structural.facade;

public class ReportWriter {

    public void writeHtmlReport(Report report, String location) {
        System.out.println("HTML Report written");

    }

    public void writePdfReport(Report report, String location) {
        System.out.println("Pdf Report written");

    }
}
