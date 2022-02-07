package Store;

import java.util.ArrayList;

/**
 * Class User
 * @Description User class that contains the user model
 * @author luis.pineda
 * @date 06-02-2022
 * @version 1.0
 */

public class User {
    private String userName;
    private ArrayList<Product> userProducts;

    public User(String userName, ArrayList<Product> userProducts) {
        this.userName = userName;
        this.userProducts = userProducts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Product> getUserProducts() {
        return userProducts;
    }

    public void setUserProducts(ArrayList<Product> userProducts) {
        this.userProducts = userProducts;
    }
}
