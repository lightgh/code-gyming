package com.chinakalight.streams;

import java.util.List;
import java.util.Random;
import java.util.stream.*;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 6/22/2020
 */
public class StreamPracOne {
    public static void main(String[] args) {
        List<Keeper> list = Stream.of("Monkey", "Kangaroo", "Lizard", "Lion")
                .filter( s -> s.startsWith("L"))
                .map(Keeper::new)
                .collect(Collectors.toList());

        List<String> stringList = Stream.of("Monkey", "Kangaroo", "Lizard", "Lion")
                .filter( s -> s.startsWith("L"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("STRING LIST: " + stringList);

        list.forEach(System.out::println);

        Stream<Keeper> emptyStream = Stream.empty();
        IntStream intStream = IntStream.empty();
        LongStream longStream = LongStream.empty();
        DoubleStream doubleStream = DoubleStream.empty();
        IntStream intStream1 = IntStream.empty();

        intStream = IntStream.of(1, 2, 3, 4);
        intStream.forEach( e -> System.out.print( e + " "));
        breakln();
        intStream = IntStream.rangeClosed(1, 9);
        intStream.forEach(e -> System.out.print( e + " " ));
        intStream = IntStream.iterate( 1, i -> i * 2);

//        intStream.forEach(e -> System.out.print( e + " " ));

        intStream = "ABCZABCaaAA".chars();
        System.out.println("\nCHARS_TO_NUM");
        intStream.forEach(System.out::println);

        IntStream randomInts = new Random().ints();



    }

    private static void breakln() {
        System.out.println("");
    }


}

class Keeper{

    private String animalName;
    public Keeper(String animalName){
        this.animalName = animalName;
    }

    public String getAnimalName(){
        return this.animalName;
    }

    public void setAnimalName(String animalName){
        this.animalName = animalName;
    }

    @Override
    public String toString() {
        return "Keeper{" +
                "animalName='" + animalName + '\'' +
                '}';
    }
}
