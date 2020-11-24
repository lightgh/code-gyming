package com.chinakalight.oraclepractice.accessmod.graphicshape;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 6/17/2020
 */
class Circles {
    void getArea() {
        Circle circle = new Circle();

        // call to public method area() within package:
        circle.area();
        // calling fillColor() with default access within package:
        circle.fillColor();
    }
}
