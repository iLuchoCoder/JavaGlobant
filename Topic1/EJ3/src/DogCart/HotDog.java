package DogCart;
/**
 * Interface HotDog
 * @Description Interface that contains the hot dog methods
 * @author luis.pineda
 * @date 06-02-2022
 * @version 1.0
 */

public interface HotDog {
    /**
     * addTopping
     * @Description Method that allows to add a topping to a basic hot dog
     * @date 06-02-2022
     * @param topping
     * @return void
     */
    public void addTopping(String topping);

    /**
     * addTopping
     *
     * @return String
     * @Description Method that display's the hot dog content
     * @date 06-02-2022
     */
    public String showHotDog();
}
