import Store.Product;
import Store.Subscriber;

class Application {
    public static void main(String args[]) {
        Product p1 = new Product("iPhone");
        Product p2 = new Product("Samsung");
        Product p3 = new Product("Xiaomi");
        Subscriber s1 = new Subscriber("Lewis");
        Subscriber s2 = new Subscriber("Lando");
        // Product subscribing
        p1.addSubscriber(s1);
        p1.addSubscriber(s2);
        p2.addSubscriber(s1);
        p3.addSubscriber(s1);
        p3.addSubscriber(s2);
        //Product 1 - price update
        p1.sendNews("Change price: Now 940");
        // Subscriber 2 - Unsubscribe from product 1
        p1.removeSubscriber(s2);
        //Product 1 - price update
        p1.sendNews("Change price: Now 900");
        //Product 2 - price update
        p2.sendNews("Change price: Now 800");
        //Product 3 - price update
        p3.sendNews("Change price: Now 600");
        // Subscriber 1 - Unsubscribe from product 3
        p3.removeSubscriber(s1);
        //Product 3 - price update
        p3.sendNews("Change price: Now 550");
    }
}

