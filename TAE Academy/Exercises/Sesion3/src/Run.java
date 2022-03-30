import model.Menu;
import model.Restaurant;

import java.util.Scanner;

public class Run {

    public static Restaurant restaurant = new Restaurant();

    public static void menu(){
        System.out.println("**********************************************************************");
        System.out.println("1 - Create Restaurant");
        System.out.println("2 - Replace a menu (Third One)");
        System.out.println("3 - Print all menu with name and prices");
        System.out.println("Q - Quit Application");
        System.out.println("Enter option:");
        System.out.println("**********************************************************************");
    }

    public static void initializeRestaurant(Restaurant res, String name){
        res.setRestaurant_name(name);
        Menu menu1 = new Menu("Masala Dosa",25000);
        Menu menu2 = new Menu("Ramen",22000);
        Menu menu3 = new Menu("Som Tam",15000);
        Menu menu4 = new Menu("Poutine",18000);
        Menu menu5 = new Menu("Fajitas",12000);
        res.getMenus().add(menu1);
        res.getMenus().add(menu2);
        res.getMenus().add(menu3);
        res.getMenus().add(menu4);
        res.getMenus().add(menu5);
    }

    public static void listMenuPrice(){
        System.out.println(restaurant.getRestaurant_name() + " menu :)");
        restaurant.getMenus().forEach((Menu m) -> System.out.println(m.getName() + " - Price: " + m.getPrice()));
    }

    public static void main(String[] args) {
        Scanner lector=new Scanner(System.in);
        String ans = "";
        while(true) {
            menu();
            ans = lector.nextLine();
            if (ans.equalsIgnoreCase("Q")) {
                break;
            }
            if (ans.equalsIgnoreCase("1")) {
                System.out.println("Enter the Restaurants name");
                ans = lector.nextLine();
                String name = ans;
                initializeRestaurant(restaurant,name);
            }
            if (ans.equalsIgnoreCase("2")) {
                System.out.println("Enter the menu name");
                ans = lector.nextLine();
                String name = ans;

                System.out.println("Enter the menu price");
                ans = lector.nextLine();
                int price = Integer.parseInt(ans);

                Menu nm = new Menu(name, price);

                restaurant.getMenus().set(2,nm);
                listMenuPrice();
            }
            if (ans.equalsIgnoreCase("3")) {
                listMenuPrice();
            }
        }

    }
}
