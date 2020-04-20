package com.chinakalight.algo.otherpractice;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 4/19/2020
 */
public class MapDrills2 {

    public static void main(String[] args) {

        // Creating HashMap
        Map<Integer, String> mapHttpErrors = new HashMap<>();
        mapHttpErrors.put(200, "OK");
        mapHttpErrors.put(303, "See Other");
        mapHttpErrors.put(404, "Not Found");
        mapHttpErrors.put(500, "Internal Server Error");

        Map<Integer, String> mapErrors = new HashMap<>(mapHttpErrors);
        Map<Integer, String> mapErrors3 = new HashMap<>(mapHttpErrors);
        mapErrors.put(404, "System Not Found");
        System.out.println(mapErrors);
        System.out.println(mapErrors3);
        System.out.println(mapHttpErrors);

        // Creating LinkedhashMap
        Map<String, String> mapContacts = new LinkedHashMap<>();
        mapContacts.put("0803691788", "Light");
        mapContacts.put("0818971788", "Tom");
        mapContacts.put("0818971799", "Peter");
        mapContacts.put("0818971798", "Mary");
        mapContacts.put("0818122221", "John");

        System.out.println(mapContacts);


        // Creating TreeMap
        Map<String, String> mapLang = new TreeMap<>();

        mapLang.put(".c", "C");
        mapLang.put(".java", "Java");
        mapLang.put(".pl", "Perl");
        mapLang.put(".cs", "C#");
        mapLang.put(".php", "php");
        mapLang.put(".cpp", "C++");
        mapLang.put(".xml", "XML");
        mapLang.put("12", "XML");
        mapLang.put("34", "XML");
        mapLang.put("1", "XML");
        mapLang.put("23", "XML");

        System.out.println(mapLang);

        System.out.println("mapLang = " + mapLang.get("34"));

        //Basic Operations on a Map
        Map<Integer, String> mapHttpErrorsSamp = new HashMap<>();
        mapHttpErrors.put(400, "Bad Request");
        mapHttpErrors.put(304, "Not Modified");
        mapHttpErrors.put(200, "OK");
        mapHttpErrors.put(301, "Moved Permanently");
        mapHttpErrors.put(500, "Internal Server Error");

        String status301 = mapHttpErrors.get(301);
        System.out.println("301: " + status301);

        if(mapHttpErrors.containsKey(200)){
            System.out.println("Http status 200");
        }

        // Checking if the map contains a specified value:
        if(mapHttpErrors.containsValue("OK")){
            System.out.println("Found status OK");
        }

        String removedValue = mapHttpErrors.remove(500);

        if(removedValue != null ){
            System.out.println( "Removed value: " + removedValue );
        }

        System.out.println("Map before: " + mapHttpErrors);

        mapHttpErrors.replace(304, "No Changes");

        System.out.println("Map after: " + mapHttpErrors);

        // getting the Size of the map
        int size = mapHttpErrors.size();
        System.out.println("Number of HTTP status code: " + size );


        // Iterating over a Map (Using Collection Views)
        Map<String, String> mapCountryCodes = new HashMap<>();
        mapCountryCodes.put("1", "USA");
        mapCountryCodes.put("44", "United Kingdom");
        mapCountryCodes.put("33", "France");
        mapCountryCodes.put("81", "Japan");

        Set<String> setCodes = mapCountryCodes.keySet();
        Iterator<String> iterator = setCodes.iterator();

        while(iterator.hasNext()){
            String code = iterator.next();
            String country = mapCountryCodes.get(code);
            System.out.println( code + " => " + country );
        }

        Collection<String> countries = mapCountryCodes.values();
        for (String country : countries){
            System.out.println(country);
        }

        Set<Map.Entry<String, String>> entries = mapCountryCodes.entrySet();

        for(Map.Entry<String, String> entry : entries){
            String code = entry.getKey();
            String country = entry.getValue();
            System.out.println(code + " => " + country );
        }

        mapCountryCodes.forEach((code, country) -> System.out.println(code + " => " + country));

        mapHttpErrors.clear();
        System.out.println("Is map empty? " + mapHttpErrors.isEmpty());

        Map<Integer, String> countryCodesEU = new HashMap<>();
        countryCodesEU.put(44, "United Kingdom");
        countryCodesEU.put(33, "France");
        countryCodesEU.put(49, "Germany");
        countryCodesEU.put(82, "Halima");

        Map<Integer, String> countryCodesWorld = new HashMap<>();
        countryCodesWorld.put(1, "United States");
        countryCodesWorld.put(86, "China");
        countryCodesWorld.put(82, "South Korea");
//        countryCodesWorld.computeIfAbsent()

        System.out.println("Before: " + countryCodesWorld);

        countryCodesWorld.putAll(countryCodesEU);

        System.out.println("After: " + countryCodesWorld);

        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());

        Set<Integer> keySet = map.keySet();

        synchronized (map){
            Iterator<Integer> keySetIterator = keySet.iterator();;
            String value = map.get(keySetIterator);
        }

//        Stream

//        Arrays.stream(nums).reduce(0, (acc, val) -> acc ^ val );

        String sampString = "this";
        System.out.println("ANOTHERSTRING___STRING");
        System.out.println(Stream.of(sampString.split(""))
        .sorted().peek(c -> System.out.println(c)).collect(Collectors.joining()));

        System.out.println(Stream.of(sampString.split(""))
        .sorted().peek(c -> System.out.println(c)).collect(Collectors.joining()));

        String str = "thisStringCharPracticeTest";
        Set<Character> c = Arrays.stream(str.split(""))
                .map(e -> e.charAt(0)).sorted().peek(s -> System.out.println(s)).collect(Collectors.toSet());


    }
}
