package DogCart;
/**
 * Class BasicHotDog
 * @Description Class that implements a basic hotdog
 * @author luis.pineda
 * @date 06-02-2022
 * @version 1.1
 */

public class BasicHotDog implements HotDog {

    /**
     * createHotDog
     *
     * @return void
     * @Description Interface method to be implemented
     * @date 06-02-2022
     */
    @Override
    public void createHotDog(String topping) {
        System.out.println("HotDog: Bread, Sausage");
    }
}
