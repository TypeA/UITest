package com.livejournal.uitests.utility.date;

/**
 *
 * @author m.prytkova
 */
public class PostTime {
    
        public static String getCurrentDate() {
        Integer day = Date.getCurrentDay();
        Integer month = Date.getCurrentMonth();
        Integer year = Date.getCurrentYear();
        Integer hour = Date.getCurrentTime("hour") - 1;
        Integer min = Date.getCurrentTime("min");

        String dop_month = "";
        String dop_day = "";
        String dop_min = "";
        if (month.toString().length() == 1) {
            dop_month = "0";
        }
        if (day.toString().length() == 1) {
            dop_day = "0";
        }
        if (min.toString().length() == 1) {
            dop_min = "0";
        }
        return dop_month + month + "/" + dop_day + day + "/" + year + ";" + hour + ":" + dop_min + min;
    }

    public static String getCorrectDate(String parameter, String value) {
        Integer day = Date.getCurrentDay();
        Integer month = Date.getCurrentMonth();
        Integer year = Date.getCurrentYear();
        Integer hour = Date.getCurrentTime("hour") - 1;
        Integer min = Date.getCurrentTime("min");

        switch (DateType.valueOf(parameter.toUpperCase())) {
            case DAY:
                day = day + Integer.valueOf(value);
                if (day > 28) {
                    day = 1;
                    month = month + 1;
                }
                if (day < 1) {
                    day = 1;
                    month = month - 1;
                }
                break;
            case MONTH:
                month = month + Integer.valueOf(value);
                if (month > 12) {
                    month = 1;
                    year = year + 1;
                }
                if (month < 1) {
                    month = 1;
                    year = year - 1;
                }
                break;
            case YEAR:
                year = year + Integer.valueOf(value);
                break;
            case HOUR:
                hour = hour + Integer.valueOf(value);
                if (hour > 23) {
                    hour = 23;
                }
                if (hour < 0) {
                    hour = 0;
                }
                break;
            case MIN:
                min = min + Integer.valueOf(value);
                if (min > 59) {
                    min = 59;
                }
                if (min < 0) {
                    min = 0;
                }
                break;
            default:
                break;
        }

        String dop_month = "";
        String dop_day = "";
        String dop_min = "";
        if (month.toString().length() == 1) {
            dop_month = "0";
        }
        if (day.toString().length() == 1) {
            dop_day = "0";
        }
        if (min.toString().length() == 1) {
            dop_min = "0";
        }
        return dop_month + month + "/" + dop_day + day + "/" + year + ";" + hour + ":" + dop_min + min;
    }

    public static String convertPostTime(String time, String format) {
        switch (format) {
            case "post":
                if (time.length() < 16) {
                    time = time.replaceAll(";", ";0");
                }
                time = time.substring(6, 10) + "-"
                        + time.substring(0, 2) + "-"
                        + time.substring(3, 5) + " "
                        + time.substring(11, 16) + ":00";
                return time;
            case "scheduled post":
                return Date.getManthByIndex(time.substring(0, 2))
                        + " " + time.substring(3, 5)
                        + ", " + time.substring(6, 10)
                        + ", " + time.substring(11, 16);
            default:
                return time;

        }
    }

}
