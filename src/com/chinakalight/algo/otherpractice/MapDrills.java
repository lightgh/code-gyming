package com.chinakalight.algo.otherpractice;

import java.util.*;

/**
 * @author - Chinaka .I. Light <chinakalight@googlemail.com>
 * Date: 4/16/2020
 */
public class MapDrills {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<String, String>();

        map1.put("GFG", "geekforgeeks.org");
        map1.put("Practice", "practice.geeksforgeeks.org");
        map1.put("Code", "code.geeksforgeeks.org");
        map1.put("Quiz", "quiz.geeksforgeeks.org");

        for(Map.Entry<String, String> entry : map1.entrySet()){
            System.out.print("Key: " + entry.getKey());
            System.out.println(" Value: " + entry.getValue());
        }

        Map<String, String> map2 = new HashMap<String, String>();

        map2.put("leader", "Light Chinaka");
        map2.put("admin", "Praise Chinaka");
        map2.put("song_leader", "Kingson Ana");
        map2.put("song_backup1", "Hanner Peterson");
        map2.put("dress_code1", "Full Gown Clothes");
        map2.put("dress_code2", "Hanna Part Gown Clothes");

//        Map.Entry<String, String> entry2 =  map2.entrySet().iterator().next();

        for(Map.Entry<String, String> entry : map2.entrySet() ){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println(map2.get("leader"));

        map2.keySet().forEach(e -> System.out.println("key: " + e));
        map2.values().forEach(e -> System.out.println("value: " + e));


        Iterator<Map.Entry<String, String>> itr = map2.entrySet().iterator();

        while(itr.hasNext()){
            Map.Entry<String, String> entry = itr.next();
            System.out.println("Key = " + entry.getKey());
            System.out.println("Value = " + entry.getValue());
        }

        map2.forEach((k, v) -> {
            System.out.println("-Key: " + k);
            System.out.println("-Value: " + v);
        });

        Map<String, Object> samp1 = new HashMap<String, Object>();
        samp1.put("learn", "Kinger");
        samp1.put("hanner", new Person("Hanner"));
        samp1.put("numb", new Person("Peterson"));
        samp1.put("jack", new Rita("Jack"));

        for(Map.Entry<String, Object> eachEntry : samp1.entrySet()){
            System.out.println("VALUE: " + eachEntry.getValue());
            System.out.println("KEY: " + eachEntry.getKey());
        }

        samp1.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });

        Map<String, List<String>> map3 = new HashMap<String, List<String>>();
        List<String> listOfCourses = new ArrayList<String>();
        List<String> listOfHobbies = new ArrayList<String>();
        listOfCourses.add("Mathematics");
        listOfCourses.add("English");
        listOfCourses.add("Social Studies");
        listOfCourses.add("Further Mathematics");
        listOfCourses.add("Political Science");

        listOfHobbies.add("Football");
        listOfHobbies.add("Volleyball");
        listOfHobbies.add("Swimming");
        listOfHobbies.add("Reading");
        map3.put("courses", listOfCourses);
        map3.put("hobbies", listOfHobbies);
        map3.put(null, listOfCourses);

        // Loop Through and Display the Records

        map3.forEach((key, value) ->{
            System.out.printf("\nTitle: %s\n\t", key);
            value.forEach(eachVal -> System.out.printf("%s\n\t",eachVal));
        });

        map3.entrySet().stream().forEach(e -> {
            System.out.printf("\n%s:\n\t", e.getKey());
            System.out.printf("%s:\n\t", e.getValue());
        });

        map3.entrySet().stream().forEach(eachM -> {
            System.out.printf("\n%s:\n\t", eachM.getKey());
            eachM.getValue().stream().forEach(subM -> {
                System.out.printf("%s:\n\t", subM);
            });
        });

        map3.put(null, null);
        map3.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });

        System.out.println(map3);

    }
}
    class Person{
        String name;
        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    class Rita{
        String ritaName;
        Rita (String ritaName){
            this.ritaName = ritaName;
        }

        @Override
        public String toString() {
            return "Rita{" +
                    "ritaName='" + ritaName + '\'' +
                    '}';
        }
    }