package com.livejournal.uitests.utility;

/**
 *
 * @author m.prytkova
 */
public class VerifyText {


    public String okTextForURL(String page, String URL) {
        return  "You are in " + page + "\n URL contains: " + URL;
    }

    public String errorTextForURL(String page, String URL, String current_URL) {
        return "You are not in " + page + "!\n Current URL: " + current_URL;
    }

    public String okTextForMessage(String message) {
        return "Correct text on Page.\nText contains:" + message;
    }

    public String errorTextForMessage(String message, String current_text) {
        return "Incorrect text on Page!\nCurrent text: " + current_text;
    }

}
