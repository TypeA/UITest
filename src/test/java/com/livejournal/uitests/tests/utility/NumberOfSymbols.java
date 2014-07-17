/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.tests.utility;

/**
 *
 * @author m.prytkova
 */
public class NumberOfSymbols {
    
   public static String get (String data, int number){
       String newSumbols= "";
       for (int i=1; i<=number+1;i++)
           newSumbols=newSumbols+"i";      
        return data.replace("NOS", newSumbols);
   }
    
}
