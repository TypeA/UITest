package com.livejournal.uitests.utility;

import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;

/**
 *
 * @author m.prytkova
 */
public class VerifyText {

    private static String ok_text;
    private static String error_text;

    public static String okTextForURL(String page, String URL) {
        return ok_text = "You are in " + page + "\n URL contains: " + URL;
    }

    public static String errorTextForURL(String page, String URL, String current_URL) {
        return error_text = "You are not in " + page + "!\n Current URL: " + current_URL;
    }

    public static String okTextForMessage(String message) {
        return ok_text = "Correct text on Page.\nText contains:" + message;
    }

    public static String errorTextForMessage(String message, String current_text) {
        return error_text = "Incorrect text on Page!\nCurrent text: " + current_text;
    }

}
