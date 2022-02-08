import DogCart.BasicHotDog;
import DogCart.HotDog;
import DogCart.HotDogDecorator;
import DogCart.HotDogTopping;

import java.util.Scanner;

/**
 * Class Application
 * @Description Main class that runs the application
 * @author luis.pineda
 * @date 06-02-2022
 * @version 1.0
 */

public class Application {
    /**
     * menuDogCart
     *
     * @return void
     * @Description Method that display's Dog Cart menu
     * @date 06-02-2022
     */
    public static void menuDogCart(){
        System.out.println("**********************************************************************");
        System.out.println("Do you want to add any topping?");
        System.out.println("1- Yes");
        System.out.println("2- No");
        System.out.println("Q- Quit App");
        System.out.println("**********************************************************************");
    }
    public static void main(String[] args) {
        {
            Scanner read = new Scanner(System.in);
            while (true) {
                HotDog hotdog = new HotDogTopping(new BasicHotDog());
                menuDogCart();
                String ans = read.nextLine();
                if (ans.toUpperCase().equals("Q") || ans.equals("2")) {
                    break;
                }
                if(ans.equals("1")){
                    System.out.println("Write your topping to add");
                    ans = read.nextLine();

                    hotdog.createHotDog(ans);
                }
            }
        }
    }
}
