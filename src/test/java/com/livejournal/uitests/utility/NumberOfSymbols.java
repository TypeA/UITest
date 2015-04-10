package com.livejournal.uitests.utility;

/**
 *
 * @author m.prytkova
 */
public class NumberOfSymbols {

    public static String get(String data, int number) {
        String newSumbols = "";
        for (int i = 1; i <= number + 1; i++) {
            newSumbols = newSumbols + "a";
        }
        return data.replace("NOS", newSumbols);
    }

}
