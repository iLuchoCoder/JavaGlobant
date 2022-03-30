package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String restaurant_name;
    private List<Menu> menus = new ArrayList<>();

    public Restaurant(String restaurant_name, List<Menu> menus) {
        super();
        this.restaurant_name = restaurant_name;
        this.menus = menus;
    }

    public Restaurant() {
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
