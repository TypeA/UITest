package com.livejournal.uitests.utility;

/**
 *
 * @author m.prytkova
 */
public class VerufyTextForURL {

    private static String ok_text;
    private static String error_text;

    public static String okText(String page, String URL) {
        return ok_text = "You in " + page + "\n URL contains: " + URL;
    }

    public static String errorText(String page, String URL, String current_URL) {
        return error_text = "You not in " + page + "!\n Current URL: " + current_URL + "\nCorrect URL contains: " + URL;
    }


}
