package org.alexandra;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        HashSet<Restaurant> restaurants = new HashSet<>();

        restaurants.add(new Restaurant("Dirty Burger", 6));
        restaurants.add(new Restaurant("Burger", 7));
        restaurants.add(new Restaurant("Burger", 8));
        restaurants.add(new Restaurant("Dirty Burger", 6));

        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.getName() + "  Score:" + restaurant.getScore());
        }
    }
}