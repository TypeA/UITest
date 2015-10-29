package com.livejournal.uitests.utility;

import java.util.ArrayList;

/**
 *
 * @author m.prytkova
 */
public class Verification {

    public boolean sameArrayLists(ArrayList<String> actual, ArrayList<String> expected) {
        Integer size = actual.size();
        return expected.containsAll(actual) && size.equals(expected.size());
    }

}
