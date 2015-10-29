package com.livejournal.uitests.utility.date;

import java.util.Calendar;

/**
 *
 * @author m.prytkova
 */
public class Date {

    public static Integer parcseDay(String day) throws Exception {
        return Integer.parseInt(day);
    }

    public static Integer getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public static Integer parceDayOrGetCurrent(String day) {
        try {
            return parcseDay(day);
        } catch (Exception ex) {
            return getCurrentDay();
        }
    }

    public static Integer parcseMonth(String month) throws Exception {
        return Integer.parseInt(month);
    }

    public static Integer getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    public static Integer parceMonthOrGetCurrent(String month) {
        try {
            return parcseMonth(month);
        } catch (Exception ex) {
            return getCurrentMonth();
        }
    }

    public static Integer parcseYear(String year) throws Exception {
        return Integer.parseInt(year);
    }

    public static Integer getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static Integer parceYearOrGetCurrent(String year) {
        try {
            return parcseYear(year);
        } catch (Exception ex) {
            return getCurrentYear() - 14;
        }
    }

    public static Integer getCurrentTime(String type) {
        switch (DateType.valueOf(type.toUpperCase())) {
            case HOUR:
                return Integer.valueOf(Calendar
                        .getInstance()
                        .getTime()
                        .toString()
                        .substring(11, 11 + 2));
            case MIN:
                return Integer.valueOf(Calendar
                        .getInstance()
                        .getTime()
                        .toString()
                        .substring(14, 14 + 2));
            case SEC:
                return Integer.valueOf(Calendar
                        .getInstance()
                        .getTime()
                        .toString()
                        .substring(17, 17 + 2));
            default:
                return null;
        }
    }

    public static String getManthByIndex(String index) {
        String month = null;
        switch (index) {
            case "01":
                month = "January";
                break;
            case "02":
                month = "February";
                break;
            case "03":
                month = "March";
                break;
            case "04":
                month = "April";
                break;
            case "05":
                month = "May";
                break;
            case "06":
                month = "June";
                break;
            case "07":
                month = "July";
                break;
            case "08":
                month = "August";
                break;
            case "09":
                month = "September";
                break;
            case "10":
                month = "October";
                break;
            case "11":
                month = "November";
                break;
            case "12":
                month = "December";
                break;
        }
        return month;
    }
}
