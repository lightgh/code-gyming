package com.chinakalight.algo.complexity;

/**
 * @author - Chinaka .I. Light <chinakalight@googlemail.com>
 * Date: 4/13/2020
 */
public class GymStage1 {
    public static void main(String[] args) {
        int[] items = {34, 23, 11, 22, 33};
        printFirstItem(items);

    }

    // O(1) time or ("constant time")
    public static void printFirstItem(int[] items){
        System.out.println(items[0]);
    }

}
