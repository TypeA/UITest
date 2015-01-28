package com.livejournal.uitests.utility;

import java.util.ArrayList;

/**
 *
 * @author s.savinykh
 */
public class ParseString {
    
    public static ArrayList<String> getParsedString(String inString,String parseSymbol)
    { 
        String[] stringArray = inString.split(parseSymbol);
        ArrayList<String> outArray = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            outArray.add(stringArray[i]);
        }
        return outArray;
        
    }
}
