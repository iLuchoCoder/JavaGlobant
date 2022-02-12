package api.interfaces;

public class PrinterMain {
    public static void main(String[] args) {
        Printer bwPrinter = new BlackWhitePrinter();
        bwPrinter.print("Hello, world");

        // Printer colorPrinter = (string) -> System.out.println("Full color printing: " + string);

        Printer colorPrinter = (string) -> {
            System.out.println("Full color printing: " + string);
        };
        colorPrinter.print("I love functional programming");
    }
}
