/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.utility;

/**
 *
 * @author m.panferova
 */
public class RandomOnlyChar {
      public static String getRandomChar(int n){
           StringBuilder text = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = (char) ((int) 'a' + Math.random() * ((int) 'z' - (int) 'a' + 1));
            char a = (char) ((int) 'A' + Math.random() * ((int) 'Z' - (int) 'A' + 1));
            text.append(c).append(a);
        }
        return text.toString();
    }
}
