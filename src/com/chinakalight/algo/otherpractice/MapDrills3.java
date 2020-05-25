package com.chinakalight.algo.otherpractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 4/25/2020
 */
public class MapDrills3 {
    public static void main(String[] args) {
        Map<String, String> listOfMonths = new HashMap<>();
        listOfMonths.put("June", "June");
        listOfMonths.put("March", "March");
        listOfMonths.put("January", "January");
        listOfMonths.put("February", "February");
        listOfMonths.put("May", "May");
        listOfMonths.put("December", "December");
        listOfMonths.put("April", "April");
        listOfMonths.put("July", "July");
        listOfMonths.put("August", "August");
        listOfMonths.put("September", "September");
        listOfMonths.put("October", "October");
        listOfMonths.put("November", "November");

        final Comparator<String> dateCompare = new Comparator<String>() {

            public int compare(String o1, String o2) {

                SimpleDateFormat s = new SimpleDateFormat("MMM");
                Date s1 = null;
                Date s2 = null;
                try {
                    s1 = s.parse(o1);
                    s2 = s.parse(o2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return s1.compareTo(s2);
            }
        };


        SimpleDateFormat s = new SimpleDateFormat("MMM");
        try {
            Date s1 = s.parse("JANUARY");
            Date s2 = s.parse("FEBRUARY");
            Date s3 = s.parse("MARCH");

            System.out.println("DATE::LLLL: ");
            System.out.println(s1.toString());
            System.out.println(s2.toString());

            System.out.println("January => Compared To February|   " + s1.compareTo(s2));
            System.out.println("February => Compared To January|   " + s2.compareTo(s1));
            System.out.println("February => Compared To March|   " + s2.compareTo(s3));
            System.out.println("January => Compared To March|   " + s1.compareTo(s3));
            System.out.println("March => Compared To January|   " + s3.compareTo(s1));
            System.out.println("March => Compared To February|   " + s3.compareTo(s2));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map<String, String> sorted = listOfMonths.entrySet().stream().sorted(comparingByKey(dateCompare))
                .collect(Collectors.toMap(e -> e.getKey(), e ->e.getValue(), (e1, e2) -> e2, LinkedHashMap::new ));

        System.out.println(sorted);
    }
}
