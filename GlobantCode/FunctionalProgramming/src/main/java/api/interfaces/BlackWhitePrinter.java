package api.interfaces;

public class BlackWhitePrinter implements Printer {
    @Override
    public void print(String string) {
        System.out.println("Printing in black/white scale: " + string);
    }
}
