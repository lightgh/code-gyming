package com.chinakalight.algo.complexity;

/**
 * @author - Chinaka .I. Light <chinakalight@googlemail.com>
 * Date: 4/13/2020
 */
public class GymStage1 {
    public static void main(String[] args) {
        int[] items = {34, 23, 11, 22, 33};
        printFirstItem(items);
        printAllItems(items);
        printAllPossibleOrderedPairs(items);
        sayHiNTimes(30);
        printAllItemsTwice(items);
        printFirstItemThenFirstHalfThenSayHi100Times(items);
    }

    // O(1) time or ("constant time")
    public static void printFirstItem(int[] items){
        System.out.println(items[0]);
    }

    // O(n) time or ("Linear time")
    public static void printAllItems(int[] items){
        for (int item :
                items) {
            System.out.println(item);
        }
    }

    // O(n^2) time (or "quadratic time")
    public static void printAllPossibleOrderedPairs(int[] items){
        for(int firstItem : items){
            for(int secondItem : items){
                System.out.println(firstItem + ", " + secondItem);
            }
        }
    }

    // Linear Time - O(n)
    public static void sayHiNTimes(int n){
        for (int i = 0; i < n; i++) {
            System.out.println("hi");
        }
    }

    /**
     * Summation of both Loops
     * O(2n) -> 2 x O(n) ->reduced to O(n)
     * and called O(n) instead of O(2n)
     * @param items
     */
    public static void printAllItemsTwice(int[] items){

        // First Linear Time loop O(n)
        for (int item :
                items) {
            System.out.println(item);
        }

        // Second Linear Time loop O(n)
        for (int item :
                items) {
            System.out.println(item);
        }
    }

    /**
     * O(n) - Constant Time +
     * O(n/2) - linear Time +
     * O(100) - linear Time
     *
     * Total = O(1 + n/2 + 100) ==> O(n)
     * @param items
     */
    public static void printFirstItemThenFirstHalfThenSayHi100Times(int[] items){
        System.out.println(items[0]);

        int middleIndex = items.length/2;
        int index = 0;

        while(index < middleIndex){
            System.out.println(items[index]);
            index++;
        }

        for (int i = 0; i < 100; i++) {
            System.out.println("hi");
        }
    }

}
