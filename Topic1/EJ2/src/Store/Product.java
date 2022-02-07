package Store;
/**
 * Class Product
 * @Description Product class that contains the product model
 * @author luis.pineda
 * @date 06-02-2022
 * @version 1.0
 */
public class Product {

    private String productName;
    private int productPrice;

    public Product(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
