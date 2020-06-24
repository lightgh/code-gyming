package com.chinakalight.oraclepractice.appcanvas;

import com.chinakalight.oraclepractice.graphicshape.Circle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author - Chinaka .I. Light <chinakalight@googlemail.com>
 * Date: 3/29/2020
 */
class Canvas {

    void getArea(){
        Circle circle = new Circle();
        circle.area(); // call to public method area(), outside package
    }

    public static void main(String[] args) {
        List<String> ars = Arrays.asList("Lin", "King", "Pent");
        String[] ars2 = (String[])ars.toArray();
        String ann = String.join(", ",  ars2);
        String ann2 = ars.stream().map(s -> {
             return "'"+s+"'"; }).collect(Collectors.joining(", "));
        System.out.println(ann);
        System.out.println(ann2);

//        Boolean name = null;

        int originalInteger = Integer.MAX_VALUE;
        int reversedInteger = revertInteger( originalInteger );
        System.out.println("REVERSED NUMBER OF: "+ originalInteger + " is: " + reversedInteger );

        LinkedList<Integer> integerLinkedList = new LinkedList<>();

    }


    public static int revertInteger( int x ){
        //x = 1 3 5 5
        //x = 1
        //x = 0

        int result = 0;

        while( x > 0 ){
            int lastDigit = x % 10;
            result = result * 10 + lastDigit;
            x = x / 10;
        }

        return result;
    }

}
