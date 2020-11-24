package com.chinakalight.refactoring;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 8/12/2020
 */
public class Geometry {

    public static double area( Object shape ){
        if( shape instanceof  Circle ){
            Circle circle = (Circle) shape;
            return Math.PI * circle.radius * circle.radius;
        }
        if(shape instanceof Rectangle){
            Rectangle rectangle = (Rectangle) shape;
            return rectangle.width * rectangle.height;
        }
        if(shape instanceof Square){
            Square square = (Square) shape;
            return square.size * square.size;
        }

        throw new IllegalArgumentException("Unknown Shape provided");
    }
}
