package com.livejournal.uitests.utility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author s.savinykh
 */
public class ParseString {
    
    public static ArrayList<String> getParsedString(String inString,String parseSymbol)
    { 
        String[] stringArray = inString.split(parseSymbol);
        ArrayList<String> outArray = new ArrayList<>();
        outArray.addAll(Arrays.asList(stringArray));
        return outArray;
        
    }
}
