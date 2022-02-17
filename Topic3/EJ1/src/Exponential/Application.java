package Exponential;
/**
 * Class Application
 * @Description Main class that runs the application
 * @author luis.pineda
 * @date 16-02-2022
 * @version 1.0
 */


import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Application {
    // Formatting the number
    final static DecimalFormat df= new DecimalFormat("#0.0000");;

    /**
     * factorial
     *
     * @return int
     * @Description Returns the factorial of a number
     * @date 16-02-2022
     */
    private static int factorial(int n){
        return IntStream.range(1,n+1).reduce(1,(x,y)->x*y);
    }

    /**
     * formula
     *
     * @return float
     * @Description Returns the calculation of the series expansion of e^x
     * @date 16-02-2022
     */
    private static float formula(float x, int n){
        if(n==0)
        {
            return 1;
        }
        else {
            return (float) (Math.pow(x,n) / factorial(n))+ formula(x,n-1);
        }
    }

    /**
     * expo
     *
     * @return float
     * @Description Returns the first 10 numbers of the series expansion of e^x from a number
     * @date 16-02-2022
     */
    private static float expo(float num){
        return formula(num,9);
    }

    /**
     * menu
     *
     * @return void
     * @Description Method that display the only B/N/C printers
     * @date 11-02-2022
     */
    public static void menu(){
        System.out.println("**********************************************************************");
        System.out.println("Enter a number to calculate");
        System.out.println("Q- Quit App");
        System.out.println("**********************************************************************");
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String ans;
        menu();
        while (true) {
            ans=read.nextLine();
            if(ans.toUpperCase().equals("Q")){
                break;
            }
            else{
                System.out.println(df.format(expo(Float.parseFloat(ans))));
                menu();
            }
        }
    }
}
