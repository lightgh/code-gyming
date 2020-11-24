package com.chinakalight.mapsinjava;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 14/11/2020
 */
public class MainMapDrills {

    public static void main(String[] args) {
        Map<String, String> bioDataMap = new HashMap<>();
        bioDataMap.put("firstName", "Peterson");
        bioDataMap.put("lastName", "Adam");
        bioDataMap.put("otherName", "Pricilia");
        bioDataMap.put("gender", "Male");

        System.out.printf("Full BioInformation: %s \n", bioDataMap);


        HashMap<String, Integer> prices = new HashMap<>();
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
//        prices.put("Shirt", 400);
        System.out.println("HashMap: " + prices);

        int returnedValue = prices
                .merge("Shirt",
                        100,
                        (oldValue, newValue) -> oldValue * newValue);

        returnedValue = prices
                .merge("Shirt",
                        100,
                        (oldValue, newValue) -> oldValue * newValue);

        BiFunction<Integer, Integer, Integer> transformationBiFunction = (oldValue, newValue) -> oldValue * newValue;
        returnedValue = prices
                .merge("Shirt",
                        100,
                        transformationBiFunction);

//        returnedValue = prices
//                .put("Shirt",
//                        100);

        System.out.println("Price of Shirt: " + returnedValue);

        System.out.println("Updated Hashmap or New Prices: " + prices);


    }


}


class SubMainTrip {
    public static void main(String[] args) {
        HashMap<String, String> countries = new HashMap<>();

        countries.put("Washington", "America");
        countries.put("Canberra", "Austrailia");
        countries.put("Madrid", "Spain");

        System.out.println("HashMap: " + countries);

        // merge mapping for key Washington
        String returnedValue = countries.merge("Washington", "USA",
                (oldValue, newValue) -> oldValue + "/" + newValue);

        // print updated HashMap
        System.out.println("Updated HashMap: " + countries);
    }
}


class MergeTwoHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> prices1 = new HashMap<>();

        prices1.put("Pant", 230);
        prices1.put("Shoes", 350);

        System.out.println("HashMap 1: " + prices1);

        //create another hashmap
        HashMap<String, Integer> prices2 = new HashMap<>();

        prices2.put("Shirt", 150);
        prices2.put("Shoes", 320);
        System.out.println("HashMap 2: " + prices2);

        // forEach() access each entries of prices2
        // merge() inserts each entry from prices2 to prices1
        /*prices2.forEach((key, value) -> prices1.merge(key, value, (oldValue, newValue) -> {
            if (oldValue > newValue) {
                return oldValue;
            } else {
                return newValue;
            }
        }));*/

        // update hashmap price1 with price2 hashmap
        prices1.putAll(prices2);

        System.out.println("Merged HashMap: " + prices1);

        prices2.computeIfPresent("Pant", (key, value) -> {
            return value * 230 / 100;
        });

        prices2.computeIfAbsent("Pant", (value) -> {
            return 230 / 100;
        });

        HashMap<String, Integer> pricingItem = new HashMap<>();

        pricingItem.putAll(prices1);

        HashMap<String, Integer> extraListing = new HashMap<>();
        extraListing.put("Scarf", 500);
        extraListing.put("tie", 120);
        extraListing.put("beef", 800);
        extraListing.put("Shirt", 100);
        extraListing.put("Short", 800);

        extraListing.forEach((key, val) -> {
            pricingItem.merge(key, val, (oldVal, newVal) -> {
                if (oldVal < newVal)
                    return oldVal;
                else
                    return newVal;
            });
        });

        System.out.println("PRICING-BEFORE-REDUCTION: " + pricingItem);

        if (pricingItem.size() > 4) {
            for (Map.Entry<String, Integer> entry : pricingItem.entrySet()) {
                String key = entry.getKey();
                Integer val = entry.getValue();
                pricingItem.compute(key,
                        (curkey, curVal) -> (int) ( curVal - 10.0 / 100.0 *  curVal));
            }
        }

        System.out.println("PRICING-AFTER-REDUCTION: " + pricingItem);
        System.out.println("PRICING-AFTER-REDUCTION-VALUES: " + pricingItem.values());
        System.out.println("PRICING-AFTER-REDUCTION-KEYS: " + pricingItem.keySet());

    }
}
