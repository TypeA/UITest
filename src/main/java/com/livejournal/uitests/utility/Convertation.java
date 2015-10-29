package com.livejournal.uitests.utility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author m.prytkova
 */
public class Convertation {

    public String hexToRGB(String hex) {
        return Integer.parseInt(hex.substring(0, 2), 16) + ", " + Integer.parseInt(hex.substring(2, 4), 16) + ", " + Integer.parseInt(hex.substring(4, 6), 16);
    }

    public ArrayList<String> stringToList(String inString, String parseSymbol) {
        String[] stringArray = inString.split(parseSymbol);
        ArrayList<String> outArray = new ArrayList<>();
        outArray.addAll(Arrays.asList(stringArray));
        return outArray;

    }
    


}
