package com.livejournal.uitests.utility;

import java.util.Random;

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

    public String get() {
        return name
                .replace("rnd", "" + random.nextInt(2000000))
                .replace("rnd", "" + random.nextInt(9000000));
    }

}
