package org.alexandra;

import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        
        HashSet<Restaurant> restaurantHashSet = new HashSet<>();

        restaurantHashSet.add(new Restaurant("Dirty Burger", 6));
        restaurantHashSet.add(new Restaurant("Burger", 7));
        restaurantHashSet.add(new Restaurant("Burger", 8));
        restaurantHashSet.add(new Restaurant("Dirty Burger", 6));

        printCollection(restaurantHashSet, "HashSet");
    }

    public static void printCollection(Collection<Restaurant> restaurants, String message) {
        System.out.println("\n" + message + "\n");
        for (Restaurant restaurant : restaurants) {
            System.out.println("Name: "+ restaurant.getName() + "   Score:  " + restaurant.getScore());
        }
    }
}