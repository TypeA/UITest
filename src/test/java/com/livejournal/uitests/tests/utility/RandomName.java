package com.livejournal.uitests.tests.utility;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author m.prytkova
 */
public class RandomName {

    private Random random;
    private String name;
    
    public RandomName(String name) {
        random = new Random();
        this.name = name;
    }
    
    public String get (){
        return name.replace("rnd", "" + random.nextInt(100));
    }
    
}
