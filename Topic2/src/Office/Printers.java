package Office;
/**
 * Interface printer
 * @Description Main class that runs the application
 * @author luis.pineda
 * @date 11-02-2022
 * @version 1.0
 */

public interface Printers {
    /**
     * createPrinter
     *
     * @param id
     * @param type
     * @param namePrinter
     * @return void
     * @Description Method that creates a printer
     * @date 11-02-2022
     */
    public void createPrinter(int id, int type, String namePrinter);

    /**
     * printDocument
     *
     * @param doc
     * @return void
     * @Description Method that prints a document
     * @date 11-02-2022
     */
    public void printDocument(String doc);

    /**
     * getPrinterLabel
     *
     * @return String
     * @Description Method that returns the printers complete label according the type 1= B/N - 2 B/N/C
     * @date 11-02-2022
     */
    public String getPrinterLabel();

}
