package com.livejournal.uitests.utility;

import com.livejournal.uitests.utility.date.Date;
import com.livejournal.uitests.utility.date.PostTime;

/**
 *
 * @author m.prytkova
 */
public class Utility {

    public RandomObject random() {
        return new RandomObject();
    }

    public Calculation calculation() {
        return new Calculation();
    }

    public Convertation convertation() {
        return new Convertation();
    }

    public Verification verification() {
        return new Verification();
    }


}
