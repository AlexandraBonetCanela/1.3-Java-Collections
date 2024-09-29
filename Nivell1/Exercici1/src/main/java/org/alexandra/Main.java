package org.alexandra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Month> year = new ArrayList<>();
        year.add(new Month("January"));
        year.add(new Month("February"));
        year.add(new Month("March"));
        year.add(new Month("April"));
        year.add(new Month("May"));
        year.add(new Month("June"));
        year.add(new Month("July"));
        year.add(new Month("September"));
        year.add(new Month("October"));
        year.add(new Month("November"));
        year.add(new Month("December"));

        printMonths(year, "Inserting all Months except August:");

        year.add(7, new Month("August"));
        printMonths(year, "Adding August:");


        HashSet<Month> yearSet = new HashSet<>(year);
        printMonths(yearSet, "Inserting All months into a HashSet: ");


        yearSet.add(new Month("August"));
        printMonths(yearSet, "Duplicated August silently ignored: ");

        System.out.println("\nUsing iterator:\n");
        Iterator<Month> iterator = yearSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }

    public static void printMonths(Collection<Month> year,String message) {
        System.out.println("\n" + message + "\n");
        for (Month month : year) {
            System.out.println(month.getName());
        }
    }
}