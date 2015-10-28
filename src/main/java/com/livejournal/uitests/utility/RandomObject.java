package com.livejournal.uitests.utility;

import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class RandomObject {

    private java.util.Random random;

    public RandomObject() {
        random = new Random();
    }

    public String getRandomName(String name) {
        return name.replace("rnd", "" + random.nextInt(900000));
    }

    public String getRandomChar(int n) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = (char) ((int) 'a' + Math.random() * ((int) 'z' - (int) 'a' + 1));
            char a = (char) ((int) 'A' + Math.random() * ((int) 'Z' - (int) 'A' + 1));
            text.append(c).append(a);
        }
        return text.toString();
    }

}
