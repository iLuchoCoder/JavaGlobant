package Store;
/**
 * Class Product
 * @Description Class thay implements subject methods
 * @author luis.pineda
 * @date 08-02-2022
 * @version 1.2
 */

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
    protected List<Observer> observers = new ArrayList<Observer>();
    protected String productName;
    protected String news;

    /**
     * Product
     *
     * @param productName
     * @Description Product constructor method
     * @date 08-02-2022
     */
    public Product(String productName) {
        super();
        this.productName = productName;
        this.news = " - FROM : " + productName;
    }

    /**
     * getproductName
     *
     * @return productName
     * @Description Returns the product name
     * @date 08-02-2022
     */
    public String getproductName() {
        return productName;
    }

    /**
     * setproductName
     *
     * @param productName
     * @return productName
     * @Description Set the product name to private variable
     * @date 08-02-2022
     */
    public void setproductName(String productName) {
        this.productName = productName;
    }

    /**
     * getNews
     *
     * @return news
     * @Description Returns the message about the change of product price
     * @date 08-02-2022
     */
    public String getNews() {
        return news;
    }

    /**
     * sendNews
     *
     * @param news
     * @Description Sends the message about the change of product price
     * @date 08-02-2022
     */
    public void sendNews(String news) {
        System.out.printf("\nProduct Name: %s, News : %s\n", productName, news);
        notifySubscribers(news);
    }

    /**
     * addSubscriber
     *
     * @param observer
     * @return void
     * @Description Method that subscribe an observer
     * @date 08-02-2022
     */
    @Override
    public void addSubscriber(Observer observer) {
        observers.add(observer);
    }

    /**
     * removeSubscriber
     *
     * @param observer
     * @return void
     * @Description Method that unsubscribe an observer
     * @date 08-02-2022
     */
    @Override
    public void removeSubscriber(Observer observer) {
        observers.remove(observer);
    }

    /**
     * notifySubscribers
     *
     * @param n
     * @return void
     * @Description Method that notifies the subscribers with a message
     * @date 08-02-2022
     */
    @Override
    public void notifySubscribers(String n) {
        observers.forEach(observer -> observer.notification(news, n));
    }
}