package com.learning.service;

import java.util.*;

public class DriverClass {

    private Map<String, RestaurentDetails> brand = new HashMap<>();
    private Order order;


    protected void addRestaurent(RestaurentDetails restaurentDetails) {
        this.brand.put(restaurentDetails.restaurentId, restaurentDetails);
        System.out.println("Brand has beed added successfully");
    }

    private void addMenu(int restaurentId, Menu menu) {
        if (this.brand.containsKey(restaurentId)) {
            RestaurentDetails restaurentDetails = this.brand.get(restaurentId);
            List<MenuItem> items = restaurentDetails.getMenu().items;
            items.addAll(menu.getItems());
            System.out.println("menu added successfully");
        }
    }

    private Order placeOrder(Order order) {
        this.order = order;
        System.out.println("order has beed added");
        return order;
    }

    public static void main(String[] args) {
        DriverClass driverClass = new DriverClass();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select the option");
        System.out.println("1 .add brand");
        System.out.println("2 .add menu");
        System.out.println("3 .Place order");
        int option = scanner.nextInt();

        switch (option) {
            case 1: {
                System.out.println("add brand");
                String addBrand = scanner.next();
                RestaurentDetails restaurentDetails = new RestaurentDetails();
                restaurentDetails.setName(addBrand);
                restaurentDetails.setRestaurentId(UUID.randomUUID().toString());
                driverClass.addRestaurent(restaurentDetails);
                break;
            }
            case 2: {
                System.out.println(" For which Brad");
                int restaurentId = scanner.nextInt();
                System.out.println(" add menu");
                String itemName = scanner.nextLine();
                Menu menu = new Menu();
                MenuItem menuItem = new MenuItem();
                menuItem.setItemName(itemName);
                List<MenuItem> items = Arrays.asList(menuItem);
                menu.setItems(items);
                driverClass.addMenu(restaurentId, menu);
                break;
            }

            case 3: {
                System.out.println(" Enter Restaurent name");
                System.out.println(" Menu Item name");
                String menuItemName = scanner.nextLine();
                Order order1=new Order();
                order1.setOrderId(UUID.randomUUID().toString());
                Item item=new Item();
                item.setName(menuItemName);
                order1.getItems().add(item);
                driverClass.placeOrder(order1);
                break;
            }
        }
    }
}
