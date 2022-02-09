package Store;

/**
 * Interface Observer
 * @Description Interface that contains update method that broadcast a message
 * @author luis.pineda
 * @date 08-02-2022
 * @version 1.2
 */

public interface Observer {
    /**
     * notification
     *
     * @param handle
     * @param news
     * @return void
     * @Description Method that broadcast the product price
     * @date 08-02-2022
     */
    public void notification(String handle, String news);
}
