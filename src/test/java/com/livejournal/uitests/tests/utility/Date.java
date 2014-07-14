/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.tests.utility;

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
}
