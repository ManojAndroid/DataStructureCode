package com.learning.service;

public class RestaurentDetails {
    String restaurentId;
    String name ;
    Menu menu;

    public String getRestaurentId() {
        return restaurentId;
    }

    public void setRestaurentId(String restaurentId) {
        this.restaurentId = restaurentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
