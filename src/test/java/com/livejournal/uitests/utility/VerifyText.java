package com.livejournal.uitests.utility;

/**
 *
 * @author m.prytkova
 */
public class VerifyText {

    public static String okTextForMessage(String message) {
        return "Correct text.\nText contains: " + message;
    }

    public static String errorTextForMessage(String current_text) {
        return "Incorrect text!\nCurrent text: " + current_text;
    }

}
