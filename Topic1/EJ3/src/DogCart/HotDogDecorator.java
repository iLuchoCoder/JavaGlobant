package DogCart;
/**
 * Class HotDogDecorator
 * @Description Abstract class to add new functions
 * @author luis.pineda
 * @date 06-02-2022
 * @version 1.0
 */

public abstract class HotDogDecorator implements HotDog{
    private HotDog hd;

    /**
     * HotDogDecorator
     * @Description Hot Dog Decorator constructor
     * @date 06-02-2022
     */
    public HotDogDecorator(HotDog hd){
        this.hd = hd;
    }

    /**
     * getHotDog
     *
     * @return HotDog
     * @Description Method that returns a HotDog
     * @date 06-02-2022
     */
    protected HotDog getHotDog(){
        return hd;
    }
}
