package Store;

public class Subscriber implements Observer {
    protected String name;

    /**
     * Subscriber
     *
     * @param name
     * @Description Subscriber constructor method
     * @date 08-02-2022
     */
    public Subscriber(String name) {
        super();
        this.name = name;
    }

    /**
     * notification
     *
     * @param handle
     * @param news
     * @return void
     * @Description Method that broadcast the product price
     * @date 08-02-2022
     */
    @Override
    public void notification(String handle, String news) {
        System.out.printf("%s received news: %s - NEWS: '%s'\n",name, handle, news);
    }
}
