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

    public Integer getRandomValue(Integer value) {
        return random.nextInt(value);
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

    public String getRandomText(int n) {

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = (char) ((int) 'a' + Math.random() * ((int) 'z' - (int) 'a' + 1));
            char a = (char) ((int) 'A' + Math.random() * ((int) 'Z' - (int) 'A' + 1));
            char g = (char) ((int) ' ' + Math.random() * ((int) '\'' - (int) ' ' + 1));
            //char w = (char) ((int) '!' + Math.random() * ((int) '\\' - (int) '!' + 1));
            text.append(c).append(a).append(n);
        }
        return text.toString().replaceAll(" +", " ").trim().substring(0, n).replace("'", "").replace("\"", "");
    }

    public String getRandomRussianText(int n) {

            StringBuilder text = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char c = (char) ((int) 'а' + Math.random() * ((int) 'я' - (int) 'а' + 1));
                char a = (char) ((int) 'А' + Math.random() * ((int) 'Я' - (int) 'А' + 1));
                char g = (char) ((int) ' ' + Math.random() * ((int) '\'' - (int) ' ' + 1));
                //char w = (char) ((int) '!' + Math.random() * ((int) '\\' - (int) '!' + 1));
                text.append(c).append(a).append(n);
            }
            return text.toString().replaceAll(" +", " ").trim().substring(0, n).replace("'", "").replace("\"", "");
        }

}
