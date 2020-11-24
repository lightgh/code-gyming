package com.chinakalight.drillmemorypackage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 25/10/2020
 */
public class MemoryOverflowTest {
    public static void main(String[] args) {
        List<Object> items = new ArrayList<>(1);

        try{
            while(true){
                items.add(new Object());
            }
        }catch(OutOfMemoryError e){
            System.out.println(e.getMessage());
            System.out.println("Length Of ArrayList: " + items.size());
        }

        assert items.size() > 0 ;

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
