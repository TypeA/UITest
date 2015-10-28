package com.livejournal.uitests.utility;

import java.util.Random;

/**
 *
 * @author s.savinykh
 */
public class RandomText {

    public static String getRandomText(int n) {

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = (char) ((int) 'a' + Math.random() * ((int) 'z' - (int) 'a' + 1));
            char a = (char) ((int) 'A' + Math.random() * ((int) 'Z' - (int) 'A' + 1));
            char g = (char) ((int) ' ' + Math.random() * ((int) '\'' - (int) ' ' + 1));
            char w = (char) ((int) '!' + Math.random() * ((int) '\\' - (int) '!' + 1));
            text.append(c).append(a).append(n).append(w);
        }
        return text.toString().replaceAll(" +", " ").trim().substring(0, n).replace("'","").replace("\"","");
    }
}


