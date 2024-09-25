package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        List<Integer> inversedList = new ArrayList<>();

        ListIterator<Integer> listIterator = list.listIterator(list.size());

        System.out.println("Backward Direction Iteration: ");

        while (listIterator.hasPrevious()) {
            inversedList.add(listIterator.previous());
        }

        for (Integer item: inversedList) {
            System.out.println(item);
        }
    }
}