package com.chinakalight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println("Hello World Learning - Goals - Java");
        System.out.printf("Learning Takes Time - Be Deliberate");
        System.out.printf("Building APIS\n\n\n");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String dateInString = "1-Aug-2020";

        try {
            Date date = formatter.parse(dateInString);
            System.out.println(date.toInstant());

            java.sql.Timestamp ts = new java.sql.Timestamp(date.getTime());
            System.out.println(ts);


            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_MONTH,
                 cal.getActualMinimum(Calendar.DAY_OF_MONTH));

            Date firstDayOfTheMonth = cal.getTime();
            System.out.println(firstDayOfTheMonth);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
