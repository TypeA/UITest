package com.livejournal.uitests.utility.iterations;

import java.util.ArrayList;

/**
 *
 * @author s.savinykh
 */
public class EqualityOfArrayLists {

    public static boolean isEqual(ArrayList<String> actual, ArrayList<String> expected) {
        boolean flag = true;
        if (actual.size() != expected.size()) {
            flag = false;
        } else {
            if (expected.containsAll(actual)) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }

}
