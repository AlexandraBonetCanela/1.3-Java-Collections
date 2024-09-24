package org.alexandra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        //1.Add All months of the year except August
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

        //2.Add August
        year.add(7, new Month("August"));
        printMonths(year, "Adding August:");

        //3. Convert ArrayList in HashSet:
        HashSet<Month> yearSet = new HashSet<>(year);
        printMonths(yearSet, "Inserting All months into a HashSet: ");

        //4. Add duplicate August value to HashSet:
        yearSet.add(new Month("August"));
        printMonths(yearSet, "Duplicated August silently ignored: ");

    }

    public static void printMonths(Collection<Month> year,String message) {
        System.out.println("\n" + message + "\n");
        for (Month month : year) {
            System.out.println(month.getName());
        }
    }
}