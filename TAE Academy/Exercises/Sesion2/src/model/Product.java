package model;

public class Product {
    private int product_code;
    private String product_name;
    private int product_price;
    private int product_stock;

    public Product(int product_code,String product_name, int product_price, int product_stock) {
        super();
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_stock = product_stock;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getStock() {
        return product_stock;
    }

    public void setStock(int stock) {
        this.product_stock = stock;
    }

    public int getProduct_code() {
        return product_code;
    }

    public void setProduct_code(int product_code) {
        this.product_code = product_code;
    }

    public int getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(int product_stock) {
        this.product_stock = product_stock;
    }

    public void sellProduct(int amount){
        this.product_stock = getStock() - amount;
    }

    public void addStock(){
        this.product_stock = getStock() + 1;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_code=" + product_code +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", product_stock=" + product_stock +
                '}';
    }
}
