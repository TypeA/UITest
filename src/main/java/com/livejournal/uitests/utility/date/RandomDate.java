package com.livejournal.uitests.utility.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author p.kulich
 */
public class RandomDate extends Date {

    private static int year;
    private static int month;
    private static int day;

    public static String setRandomYear() {
        final int MIN = Date.getCurrentYear() - 100;
        final int MAX = Date.getCurrentYear();

        year = MIN + (int) (Math.random() * ((MAX - MIN) + 1));

        return String.valueOf(year);

    }

    public static String setRandomMonth() {
        final int MIN = 12;
        final int MAX = 1;

        month = MIN + (int) (Math.random() * ((MAX - MIN) + 1));

        return String.valueOf(month);

    }

    public static String setRandomDay() {
        GregorianCalendar cal
                = (GregorianCalendar) GregorianCalendar.getInstance();
        cal.set(year, month, 1);
        final int MAX = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        final int MIN = 1;
        //System.out.println(MIN + (int) (Math.random() * ((MAX - MIN) + 1)));
        return String.valueOf(MIN + (int) (Math.random() * ((MAX - MIN) + 1)));
    }

}
