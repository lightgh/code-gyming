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
}
