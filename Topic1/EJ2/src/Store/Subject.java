package Store;

/**
 * Interface Subject
 * @Description Interface that contains subscribe and unsubscribe methods
 * @author luis.pineda
 * @date 08-02-2022
 * @version 1.2
 */

public interface Subject {
    /**
     * addSubscriber
     *
     * @param observer
     * @return void
     * @Description Method that subscribe an observer
     * @date 08-02-2022
     */
    public void addSubscriber(Observer observer);

    /**
     * removeSubscriber
     *
     * @param observer
     * @return void
     * @Description Method that unsubscribe an observer
     * @date 08-02-2022
     */
    public void removeSubscriber(Observer observer);

    /**
     * notifySubscribers
     *
     * @param message
     * @return void
     * @Description Method that notifies the subscribers with a message
     * @date 08-02-2022
     */
    public void notifySubscribers(String message);
}