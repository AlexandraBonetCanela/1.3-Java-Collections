package org.alexandra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        // Exercise 1
        HashSet<Restaurant> restaurantHashSet = new HashSet<>();

        restaurantHashSet.add(new Restaurant("Dirty Burger", 6));
        restaurantHashSet.add(new Restaurant("Burger", 7));
        restaurantHashSet.add(new Restaurant("Burger", 8));
        restaurantHashSet.add(new Restaurant("Dirty Burger", 6));

        printCollection(restaurantHashSet, "HashSet");

        // Exercise 2
        ArrayList<Restaurant> restaurantArrayList = new ArrayList<>(restaurantHashSet);
        printCollection(restaurantArrayList, "Unordered list");

        restaurantArrayList.sort(Comparator.comparing(Restaurant::getName)
                .thenComparing(Comparator.comparingInt(Restaurant::getScore).reversed()));

        printCollection(restaurantArrayList, "Ordered list");
    }

    public static void printCollection(Collection<Restaurant> restaurants, String message) {
        System.out.println("\n" + message + "\n");
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant.getName() + "   Score:  " + restaurant.getScore());
        }
    }
}