package Office;
/**
 * Class printers
 * @Description Class that implements a printer
 * @author luis.pineda
 * @date 11-02-2022
 * @version 1.0
 */

public class Printer implements Printers {
    private String printerName;
    private int typePrinter;
    private String labelPrinter;
    private int printerID;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLUE = "\u001B[34m";


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
    @Override
    public void createPrinter(int id, int type, String namePrinter) {
        this.printerID = id;
        this.typePrinter = type;
        this.printerName = namePrinter;
    }

    /**
     * printDocument
     *
     * @param doc
     * @return void
     * @Description Method that prints a document
     * @date 11-02-2022
     */
    @Override
    public void printDocument(String doc) {
        String imp="";
        if(getTypePrinter()==1)
        {
           imp = ANSI_BLACK + doc + ANSI_RESET;
        }
        else{
            imp = ANSI_BLUE + doc + ANSI_RESET;
        }
        System.out.println(imp);
    }

    /**
     * getPrinterID
     *
     * @return int
     * @Description Method that returns the printers id
     * @date 11-02-2022
     */
    public int getPrinterID() {
        return printerID;
    }

    /**
     * getPrinterName
     *
     * @return String
     * @Description Method that returns the printers name
     * @date 11-02-2022
     */
    public String getPrinterName() {
        return printerName;
    }

    /**
     * typePrinter
     *
     * @return int
     * @Description Method that returns the printers functionality type 1= B/N - 2 B/N/C
     * @date 11-02-2022
     */
    public int getTypePrinter() {
        return typePrinter;
    }

    /**
     * getPrinterLabel
     *
     * @return String
     * @Description Method that returns the printers complete label according the type 1= B/N - 2 B/N/C
     * @date 11-02-2022
     */
    @Override
    public String getPrinterLabel()
    {
        if(getTypePrinter()==1)
        {
            this.labelPrinter = getPrinterID()+ " - " + getPrinterName() + " - " + "B/N";
        }
        else{
            this.labelPrinter = getPrinterID()+ " - " + getPrinterName() + " - " + "B/N/C";
        }
        return labelPrinter;
    }
}
