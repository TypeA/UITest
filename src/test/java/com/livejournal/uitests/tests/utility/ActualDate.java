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
public class ActualDate {
    
    private String day;
    private String monse;
    private String year;
    Calendar calendar = Calendar.getInstance();
    
    public ActualDate(String day, String monse, String year){
        this.day=day;
        this.monse=monse;
        this.year=year;    
    }
    
    public String getDay(String day){
        Integer intDay=0;
        try {
            intDay = Integer.parseInt(day);
        } catch (Exception ex){
            intDay = calendar.get(Calendar.DAY_OF_MONTH);
        }
        String Day = intDay.toString();
        return Day;
    }
    
    public String getMonth(String month){
        Integer intMonth=0;
        try {
            intMonth = Integer.parseInt(month);
        } catch (Exception ex){
            intMonth = calendar.get(Calendar.MONTH);
        }
        String Month = intMonth.toString();
        return Month;
    }
        
    public String getYear(String year){
        Integer intYear=0;
        try {
            intYear = Integer.parseInt(year);
        } catch (Exception ex){
            intYear = calendar.get(Calendar.YEAR);
        }
        String Year = intYear.toString();
        return Year;
    }
    
}
