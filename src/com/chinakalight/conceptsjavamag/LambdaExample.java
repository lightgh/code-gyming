package com.chinakalight.conceptsjavamag;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 15/10/2020
 */
public class LambdaExample {
    private static final String HELLO = "Hello World!";

    public static void main(String[] args) throws Exception {
        Runnable r = () -> System.out.println(HELLO);
        Thread t = new Thread(r);
        t.start();
        t.join();
        //System.out.println("Learning about the inner working of lambda");
        lambda$main$0name("RandomTextPrintoutTestName");
    }

    private static void lambda$main$0name(String name){
        String tempString = "InMethodString";
        name = tempString;
        System.out.println(name);
    }

}
