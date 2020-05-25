package com.chinakalight.datastructure;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 5/10/2020
 */
public class FunctionFib {

    public static void main(String[] args) {
        FunctionFib functionFib = new FunctionFib();
        functionFib.allFib(11);
    }

    void allFib(int n){
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + fib(i) );
        }
    }

    int fib(int n){
        if(n <= 0) return 0;
        else if (n == 1) return 1;
        return fib( n - 1 ) + fib( n - 2 );
    }
}