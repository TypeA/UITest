package com.livejournal.uitests.utility;

import java.util.Random;

/**
 *
 * @author m.prytkova
 */
public class RandomeValue {

    private Random random;
    private Integer value;

    public RandomeValue(Integer value) {
        random = new Random();
        this.value = value;
    }

    public Integer get() {
        return random.nextInt(value);
    }

}
