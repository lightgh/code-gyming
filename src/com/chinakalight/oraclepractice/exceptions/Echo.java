package com.chinakalight.oraclepractice.exceptions;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 28/10/2020
 */
public class Echo {
    public static void main(String[] args) {
        if(args.length == 0){
            throw new IllegalArgumentException("No input passed to echo command");
        }else{
            for (String str :
                    args) {
                System.out.println(str);
            }
        }
    }
}
