package com.livejournal.uitests.utility;

/**
 *
 * @author m.prytkova
 */
public class VerifyText {


    public static String okTextForURL(String page, String URL) {
        return  "You are in " + page + "\n URL contains: " + URL;
    }

    public static String errorTextForURL(String page, String URL, String current_URL) {
        return "You are not in " + page + "!\n Current URL: " + current_URL;
    }

    public static String okTextForMessage(String message) {
        return "Correct text.\nText contains: " + message;
    }

    public static String errorTextForMessage(String message, String current_text) {
        return "Incorrect text!\nCurrent text: " + current_text;
    }

}
