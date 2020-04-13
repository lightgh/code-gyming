package com.chinakalight.oraclepractice.graphicshape;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 3/29/2020
 */
public class Circle extends Shape {
    private int radius;
    public void area(){
        System.out.println("area: " + 3.14 * radius * radius );
    }

    void fillColor() {
        // access to protected field
        System.out.println("color: " + color );
    }
}
