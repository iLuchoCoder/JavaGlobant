import MusicPlayer.Fabric;
import MusicPlayer.Player;

import java.util.Scanner;
/**
 * Class Application
 * @Description Main class that runs the application
 * @author luis.pineda
 * @date 05-02-2022
 * @version 1.0
 */

public class Application {
    static int aColor, aCapacity, aBattery = 0;

    /**
     * menuColor
     *
     * @return void
     * @Description Method that display's the color menu
     * @date 05-02-2022
     */
    public static void menuColor(){
        System.out.println("**********************************************************************");
        System.out.println("Choose the device's color");
        System.out.println("1- Green");
        System.out.println("2- Blue");
        System.out.println("Q- Quit App");
        System.out.println("**********************************************************************");
    }

    /**
     * menuCapacity
     *
     * @return void
     * @Description Method that display's the capacity menu
     * @date 05-02-2022
     */
    public static void menuCapacity(){
        System.out.println("**********************************************************************");
        System.out.println("Choose the device's capacity");
        System.out.println("1- 8GB");
        System.out.println("2- 16GB");
        System.out.println("Q- Quit App");
        System.out.println("**********************************************************************");
    }

    /**
     * menuBattery
     *
     * @return void
     * @Description Method that display's the battery menu
     * @date 05-02-2022
     */
    public static void menuBattery(){
        System.out.println("**********************************************************************");
        System.out.println("Choose the device's battery duration");
        System.out.println("1- 5 Hours");
        System.out.println("2- 8 Hours");
        System.out.println("Q- Quit App");
        System.out.println("**********************************************************************");
    }

    /**
     * main
     *
     * @return void
     * @Description Method that runs the app
     * @date 05-02-2022
     */
    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        while(true) {
            menuColor();
            String ans = read.nextLine();
            if(ans.toUpperCase().equals("Q")){
                break;
            }
            else{
                aColor = Integer.parseInt(ans);
            }
            menuCapacity();
            ans = read.nextLine();
            if(ans.toUpperCase().equals("Q")){
                break;
            }
            else{
                aCapacity = Integer.parseInt(ans);
            }
            menuBattery();
            ans = read.nextLine();
            if(ans.toUpperCase().equals("Q")){
                break;
            }
            else{
                aBattery = Integer.parseInt(ans);
            }
            Player device = Fabric.build(aColor, aCapacity, aBattery);
            System.out.println(device.getConfiguration());
        }
    }
}
