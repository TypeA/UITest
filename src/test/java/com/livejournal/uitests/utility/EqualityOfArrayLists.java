package com.livejournal.uitests.utility;

import java.util.ArrayList;

/**
 *
 * @author s.savinykh
 */
public class EqualityOfArrayLists {

    public static boolean isEqual(ArrayList<String> actual, ArrayList<String> expected) {
        Integer size = actual.size();
        return expected.containsAll(actual)&&size.equals(expected.size());
    }

}
