package com.chinakalight.oraclepractice.accessmod.graphicshape;

import com.chinakalight.oraclepractice.accessmod.graphicshape.Shape;
/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 6/17/2020
 */
public class Circle  extends Shape {

    private int radius; // private field
    public void area() { // public method
        System.out.println("area: " + 3.14 * radius * radius);
    }

    void fillColor(){
        System.out.println( "color: " + color );
    }
}
