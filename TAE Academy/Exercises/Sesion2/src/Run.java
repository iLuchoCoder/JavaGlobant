import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static List<Product> listProducts = new ArrayList<>();

    public static void menu(){
        System.out.println("**********************************************************************");
        System.out.println("1 - List products prices");
        System.out.println("2 - Add new product in the store");
        System.out.println("3 - Sell a product according the product code");
        System.out.println("Q - Quit Application");
        System.out.println("Enter option:");
        System.out.println("**********************************************************************");
    }

    public static void initializeStore(){
        Product p1 = new Product(10,"Keyboard",35000,40);
        Product p2 = new Product(20,"Mouse",29500,100);
        Product p3 = new Product(30,"Monitor",350,40);
        Product p4 = new Product(40,"Keyboard",370000,1200);
        Product p5 = new Product(50,"USB 64GB",28500,800);
        listProducts.add(p1);
        listProducts.add(p2);
        listProducts.add(p3);
        listProducts.add(p4);
        listProducts.add(p5);
    }

    public static void addProduct(int code, String name, int price, int stock){
        Product pn = new Product(code, name,price,stock);
        listProducts.add(pn);
    }

    public static void listProductsPrice(){
        listProducts.forEach((Product p) -> System.out.println(p.getProduct_code()+ " -  " + p.getProduct_name() + " - Price: " + p.getProduct_price() + " - Stock: " + p.getStock()));
    }

    public static void main(String[] args) {
        initializeStore();
        listProductsPrice();
        Scanner lector=new Scanner(System.in);
        String ans = "";
        while(true){
            menu();
            ans = lector.nextLine();
            if(ans.equalsIgnoreCase("Q")){
                break;
            }
            if(ans.equalsIgnoreCase("1")){
                listProductsPrice();
            }
            if(ans.equalsIgnoreCase("2")){
                System.out.println("Enter the products code");
                ans = lector.nextLine();
                int code = Integer.parseInt(ans);

                System.out.println("Enter the products name");
                ans = lector.nextLine();
                String name = ans;

                System.out.println("Enter the products price");
                ans = lector.nextLine();
                int price = Integer.parseInt(ans);

                System.out.println("Enter the products initial stock");
                ans = lector.nextLine();
                int stock = Integer.parseInt(ans);

                addProduct(code,name,price,stock);

                System.out.println("The product was successfully added to the list");

                listProductsPrice();
            }
            if(ans.equalsIgnoreCase("3")){
                System.out.println("Enter the products code to sell");
                ans = lector.nextLine();
                int code = Integer.parseInt(ans);

                System.out.println("Enter the amount to sell");
                ans = lector.nextLine();
                int amount = Integer.parseInt(ans);


                Product product = listProducts.stream()
                        .filter(products -> products.getProduct_code() == code)
                        .findAny()
                        .orElse(null);

                product.sellProduct(amount);

                System.out.println("You sell " + amount + " - " +product.getProduct_name());

                listProductsPrice();
            }
        }
    }
}
