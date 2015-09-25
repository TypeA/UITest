package com.livejournal.uitests.utility;

import com.livejournal.uisteps.thucydides.Databases;

/**
 *
 * @author m.prytkova
 */
public class HexToRGB {

    public static String hexToRGB(String hex) {
        return Integer.parseInt(hex.substring(0, 2), 16) + ", " + Integer.parseInt(hex.substring(2, 4), 16) + ", " + Integer.parseInt(hex.substring(4, 6), 16);
    }

}
