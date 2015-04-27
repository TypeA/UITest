package com.livejournal.uitests.utility;

import java.util.Random;

/**
 *
 * @author s.savinykh
 */
public class RandomText {

    public static String getRandomText(int n) {

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = (char) ((int) 'a' + Math.random() * ((int) 'z' - (int) 'a' + 1));
            char a = (char) ((int) 'A' + Math.random() * ((int) 'Z' - (int) 'A' + 1));
            char g = (char) ((int) ' ' + Math.random() * ((int) '\'' - (int) ' ' + 1));
            char w = (char) ((int) '!' + Math.random() * ((int) '\\' - (int) '!' + 1));
            text.append(c).append(a).append(n).append(w);
        }
        return text.toString().replaceAll(" +", " ").trim().substring(0, n);
    }
}

//        char ch1[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//        char ch2[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//        char ch3[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '!', ',', '.', ' ', '?'};
//        //char ch3[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', ',', '.', ' ', '/', '?', '[', ']'};
//        int chi1, chn1, chi2, chn2, chi3, chn3;
//        String randomtext = "";
//        Random rnd = new Random();
//        for (int i = 0; i < 25; i++) {
//            chi1 = rnd.nextInt(ch1.length);
//            chn1 = rnd.nextInt(ch1.length-chi1);
//            chi2 = rnd.nextInt(ch2.length);
//            chn2 = rnd.nextInt(ch2.length-chi2);
//            chi3 = rnd.nextInt(ch3.length);
//            chn3 = rnd.nextInt(ch3.length-chi3);
//            String s1 = new String(ch1, chi1, chn1);
//            String s2 = new String(ch2, chi2, chn2);
//            String s3 = new String(ch3, chi3, chn3);
//            randomtext =randomtext + s1 + " " + s2 + " " + s3;
//        }
//        randomtext=randomtext.substring(0,n);
//        return randomtext;

