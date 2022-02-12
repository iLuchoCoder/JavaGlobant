import Office.Printer;
import Office.Printers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class Application
 * @Description Main class that runs the application
 * @author luis.pineda
 * @date 11-02-2022
 * @version 1.0
 */

public class Application {

    // ArrayList bn, bnc type printer to save the printers
    static ArrayList<Printer> bn = new ArrayList<>();
    static ArrayList<Printer> bnc = new ArrayList<>();
    static boolean onlyColor = false;

    /**
     * createInitialPrinters
     *
     * @return void
     * @Description Method that creates the initial printers in the office
     * @date 11-02-2022
     */
    public static void createInitialPrinters(){
        Printer pbn = new Printer();
        Printer pbnc = new Printer();

        pbn.createPrinter(1,1,"Epson1Floor");
        pbnc.createPrinter(1,2,"HP-POS");

        bn.add(pbn);
        bnc.add(pbnc);
    }

    /**
     * showPrinters
     *
     * @return void
     * @Description Method that shows the printers to the user in the command line
     * @date 11-02-2022
     */
    public static void showPrinters(ArrayList<Printer> p){
        for(int i=0;i<p.size();i++){
            System.out.println(p.get(i).getPrinterLabel());
        }
    }

    /**
     * printDocument
     *
     * @return void
     * @Description Method that print a document in the selected printer
     * @date 11-02-2022
     */
    public static void printDocument(ArrayList<Printer> p, int idPrint, String doc){
        for(int i=0;i<p.size();i++){
            if(p.get(i).getPrinterID()==idPrint){
                System.out.println("You choose the printer with the name " + p.get(i).getPrinterName());
                System.out.println("*** Printing ***");
                p.get(i).printDocument(doc);
                System.out.println("*** End Printing ***");
            }
        }
    }

    /**
     * initialMenu
     *
     * @return void
     * @Description Method that display the inicial menu
     * @date 11-02-2022
     */
    public static void initialMenu(){
        System.out.println("**********************************************************************");
        System.out.println("1- Create printer");
        System.out.println("2- Show B/N printers and choose to print a document");
        System.out.println("3- Show B/N/C printers and choose to print a document");
        System.out.println("4- Set: Show only B/N/C printers");
        System.out.println("Q- Quit App");
        System.out.println("**********************************************************************");
    }

    /**
     * onlyColorMenu
     *
     * @return void
     * @Description Method that display the only B/N/C printers
     * @date 11-02-2022
     */
    public static void onlyColorMenu(){
        System.out.println("**********************************************************************");
        System.out.println("1- Create printer");
        System.out.println("2- Show B/N/C printers and choose to print a document");
        System.out.println("Q- Quit App");
        System.out.println("**********************************************************************");
    }

    /**
     * createPrinter
     *
     * @return void
     * @Description Method that allows the user to create a B/N or B/N/C printer in the office and save it
     * @date 11-02-2022
     */
    public static void createPrinter(){
        Printer p = new Printer();
        int id, type;
        String name;
        System.out.println("Enters the printers id");
        Scanner read = new Scanner(System.in);
        id = Integer.parseInt(read.nextLine());
        System.out.println("Enters the printers type, 1 for B/N - 2 for B/N/C");
        read = new Scanner(System.in);
        type = Integer.parseInt(read.nextLine());
        System.out.println("Enters the printers name");
        read = new Scanner(System.in);
        name = read.nextLine();
        p.createPrinter(id,type,name);
        if(type==1)
        {
            bn.add(p);
        }
        else{
            bnc.add(p);
        }
        System.out.println("Printer successfully created");
    }


    public static void main(String[] args) {
        createInitialPrinters();
        initialMenu();
        Scanner read = new Scanner(System.in);
        while (true) {
            if(onlyColor==false){
                String ans = read.nextLine();
                if (ans.toUpperCase().equals("Q")) {
                    break;
                }
                if(ans.equals("1")){
                    createPrinter();
                    initialMenu();
                }
                if(ans.equals("2")){
                    showPrinters(bn);
                    System.out.println("Enters the printers id to print a document");
                    read = new Scanner(System.in);
                    int idPrinter = Integer.parseInt(read.nextLine());
                    System.out.println("Enter the document to print");
                    read = new Scanner(System.in);
                    String printDoc = read.nextLine();
                    printDocument(bn,idPrinter,printDoc);
                    initialMenu();
                }
                if(ans.equals("3")){
                    showPrinters(bnc);
                    System.out.println("Enters the printers id to print a document");
                    read = new Scanner(System.in);
                    int idPrinter = Integer.parseInt(read.nextLine());
                    System.out.println("Enter the document to print");
                    read = new Scanner(System.in);
                    String printDoc = read.nextLine();
                    printDocument(bnc,idPrinter,printDoc);
                    initialMenu();
                }
                if(ans.equals("4")){
                    onlyColor = true;
                    onlyColorMenu();
                }
            }
            else{
                String ans = read.nextLine();
                if (ans.toUpperCase().equals("Q")) {
                    break;
                }
                if(ans.equals("1")){
                    createPrinter();
                    onlyColorMenu();
                }
                if(ans.equals("2")){
                    showPrinters(bnc);
                    System.out.println("Enters the printers id to print a document");
                    read = new Scanner(System.in);
                    int idPrinter = Integer.parseInt(read.nextLine());
                    System.out.println("Enter the document to print");
                    read = new Scanner(System.in);
                    String printDoc = read.nextLine();
                    printDocument(bnc,idPrinter,printDoc);
                    onlyColorMenu();
                }
            }
        }
    }
}
