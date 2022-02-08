package DogCart;
/**
 * Class HotDogDecorator
 * @Description Abstract class to add new functions
 * @author luis.pineda
 * @date 06-02-2022
 * @version 1.0
 */

public abstract class HotDogDecorator implements HotDog{

    protected HotDog decoratedHotDog;

    /**
     * HotDogDecorator
     * @Description Hot Dog Decorator constructor
     * @date 06-02-2022
     */
    public HotDogDecorator(HotDog decoratedHotDog){
        this.decoratedHotDog = decoratedHotDog;
    }

    /**
     * createHotDog
     * @Description Interface method to be implemented
     * @date 06-02-2022
     * @return void
     */
    public void createHotDog(String topping) {
        decoratedHotDog.createHotDog(topping);
    }


}
