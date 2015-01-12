/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.utility;

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
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static Integer parceMonthOrGetCurrent(String month) {
        try {
            return parcseMonth(month);
        } catch (Exception ex) {
            return getCurrentMonth()+1;
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
            return getCurrentYear()-14;
        }
    }
}
