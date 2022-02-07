package DogCart;
/**
 * Class HotDogTopping
 * @Description Class that adds a topping to a basic hot dog
 * @author luis.pineda
 * @date 06-02-2022
 * @version 1.0
 */

public class HotDogTopping extends HotDogDecorator {

    /**
     * HotDogTopping
     * @Description Hot Dog Topping constructor
     * @date 06-02-2022
     */
    public HotDogTopping(HotDog hd){
        super(hd);
    }

    /**
     * addTopping
     *
     * @param topping
     * @return void
     * @Description Method that allows to add a topping to a basic hot dog
     * @date 06-02-2022
     */
    @Override
    public void addTopping(String topping) {
        getHotDog().addTopping(topping);
    }

    /**
     * addTopping
     *
     * @return String
     * @Description Method that display's the hot dog content
     * @date 06-02-2022
     */
    @Override
    public String showHotDog() {
        return getHotDog().showHotDog();
    }
}
