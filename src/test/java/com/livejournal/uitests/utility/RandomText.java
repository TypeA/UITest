package com.livejournal.uitests.utility;

import java.util.Random;

/**
 *
 * @author s.savinykh
 */
public class RandomText {

    public static String GetRandomText() {
        char ch1[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char ch2[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char ch3[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', ',', '.', ' ', '/', '?', '[', ']'};
        int chi1, chn1, chi2, chn2, chi3, chn3;
        String randomtext = "";
        Random rnd = new Random();
        for (int i = 0; i < 25; i++) {
            chi1 = rnd.nextInt(26);
            chn1 = rnd.nextInt(26);
            chi2 = rnd.nextInt(26);
            chn2 = rnd.nextInt(26);
            chi3 = rnd.nextInt(33);
            chn3 = rnd.nextInt(33);
            String s1 = new String(ch1, chi1, chn1);
            String s2 = new String(ch2, chi2, chn2);
            String s3 = new String(ch3, chi3, chn3);
            randomtext = s1 + " " + s2 + " " + s3;
        }
        return randomtext;

    }

}
