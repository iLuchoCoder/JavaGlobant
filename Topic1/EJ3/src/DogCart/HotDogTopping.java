package DogCart;
/**
 * Class HotDogTopping
 * @Description Class that adds a topping to a basic hot dog
 * @author luis.pineda
 * @date 06-02-2022
 * @version 1.0
 */

public class HotDogTopping extends HotDogDecorator {

    String topping;

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    /**
     * HotDogTopping
     *
     * @param decoratedHotDog
     * @Description Hot Dog Decorator constructor
     * @date 06-02-2022
     */
    public HotDogTopping(HotDog decoratedHotDog) {
        super(decoratedHotDog);
    }

    /**
     * addTopping
     * @Description Method that allows to add a topping to a basic hot dog
     * @date 06-02-2022
     * @return void
     */
    @Override
    public void createHotDog(String topping){
        decoratedHotDog.createHotDog(topping);
        addTopping(decoratedHotDog,topping);
    }

    private void addTopping(HotDog decoratedHotDog, String topping){
        System.out.println("You add this topping to your hot dog: " + topping);
    }
}
