package com.chinakalight.oraclepractice.appcanvas;

import com.chinakalight.oraclepractice.graphicshape.Circle;

import java.util.Arrays;
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
    }
}
