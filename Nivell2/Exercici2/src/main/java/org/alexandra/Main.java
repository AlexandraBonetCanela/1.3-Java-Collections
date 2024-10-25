package org.alexandra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        HashSet<Restaurant> restaurantHashSet = new HashSet<>();

        restaurantHashSet.add(new Restaurant("Dirty Burger", 6));
        restaurantHashSet.add(new Restaurant("Burger", 7));
        restaurantHashSet.add(new Restaurant("Burger", 8));
        restaurantHashSet.add(new Restaurant("Dirty Burger", 6));

        ArrayList<Restaurant> restaurantArrayList = new ArrayList<>(restaurantHashSet);

        restaurantArrayList.sort(Comparator.comparing(Restaurant::getName)
                .thenComparing(Comparator.comparingInt(Restaurant::getScore).reversed()));

        printCollection(restaurantArrayList, "Ordered list");
    }

    public static void printCollection(Collection<Restaurant> restaurants, String message) {
        for (Restaurant restaurant : restaurants) {
            System.out.println("Name: "+ restaurant.getName() + ", Score:  " + restaurant.getScore());
        }
    }
}