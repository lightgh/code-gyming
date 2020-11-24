package com.chinakalight.misc;

import java.util.HashMap;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 26/10/2020
 */
public class MiscOne {
    public static void main(String[] args) {
        HashMap<String, Integer> map
                = new HashMap<>();

        map.put("key1", 10000);
        map.put("key2", 55000);
        map.put("key3", 44300);
        map.put("key4", 53200);

        //print map details
        System.out.println("HashMap:\n " + map.toString());

        //provide value for the new key which is absent
        //using computeIfAbsent method
        map.computeIfAbsent("key5", k -> 2000 + 33000 );
        map.computeIfAbsent("key6", k -> 2000 * 34 );
        map.computeIfAbsent("key2", k -> 2000 * 34 );
        map.computeIfAbsent("key2", k -> 89999 );

//        print new mapping
        System.out.println( "New HashMap:\n " + map );

    }
}
