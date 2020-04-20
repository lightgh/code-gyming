package com.chinakalight.algo.otherpractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author - Chinaka .I. Light <chinakalight@googlemail.com>
 * Date: 4/20/2020
 */
public class StreamMapDrills {
    public static void main(String[] args) {

        //1. New HashMap Definition
        Map<String, Integer> someMap = new HashMap<>();
        // Obtaining Key - Value Pairs
        Set<Map.Entry<String, Integer>> entries = someMap.entrySet();
        //Obtaining the Keys Associated with the Map
        Set<String> keySet = someMap.keySet();
        //Obtaining the Values stored in the map
        Collection<Integer> values = someMap.values();

        //Obtaining the Streams from them
        Stream<Map.Entry<String, Integer>> entriesStream = entries.stream();
        Stream<Integer> valuesStream = values.stream();
        Stream<String> keysStream = keySet.stream();

        Map<String, String> books = new HashMap<>();
        books.put("978-0201633610", "Design patterns : elements of reusable object-oriented");
        books.put("973-878778789", "Java 8 in Action: Lambdas, Stream, and functional-style programming");
        books.put("978-0134685991", "Effective Java");

        Optional<String> optionalIsbn = books.entrySet().stream()
                .filter(e -> "Effective Java".equalsIgnoreCase(e.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        Optional<String> s = Stream.of("978-01346859910".equalsIgnoreCase(optionalIsbn.get())).map(
                e -> { return e.equals(true)?  "TRUE" :  "FALSE"; }).findFirst();

        List<String> s1 = Stream.of("978-01346859910".equalsIgnoreCase(optionalIsbn.get())).map(
                e -> { return e.equals(true)?  "TRUE" :  "FALSE"; }).collect(Collectors.toList());

        System.out.println(s.get());
        System.out.println(s1);
    }
}
