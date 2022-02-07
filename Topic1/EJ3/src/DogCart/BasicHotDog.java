package DogCart;
/**
 * Class BasicHotDog
 * @Description Class that initialize a basic hotdog and implements a hot dog
 * @author luis.pineda
 * @date 06-02-2022
 * @version 1.0
 */

import java.util.ArrayList;

public class BasicHotDog implements HotDog {
    static ArrayList<String> hotdog;

    /**
     * BasicHotDog
     * @Description Basic Hot Dog constructor
     * @date 06-02-2022
     */
    public BasicHotDog(){
        hotdog = new ArrayList<>();
        hotdog.add("Bread");
        hotdog.add("Sausage");
    }

    /**
     * addTopping
     *
     * @return String
     * @Description Method that display's the hot dog content
     * @date 06-02-2022
     */
    public String showHotDog(){
        hotdog.toString();
        String hd="[";
        for(int i=0; i< hotdog.size();i++){
            hd+=hotdog.get(i)+"-";
        }
        hd+="]";
        return hd;
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
        hotdog.add(topping);
        System.out.println("You add this topping " + topping + " " + hotdog.size());
    }
}
