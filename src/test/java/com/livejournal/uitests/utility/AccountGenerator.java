package com.livejournal.uitests.utility;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.accounts.LJAccount;
import com.livejournal.uitests.accounts.JournalType;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import org.junit.Assert;

/**
 *
 * @author ASolyankin
 */
public class AccountGenerator {

    public static synchronized LJAccount createDefaultJournal(String name) {
        return createJournal(true, false, name, 100);
    }

    public static synchronized LJAccount createDefaultCommunity(String communityOwner, String name) {
        return createCommunity(communityOwner, true, false, name, 100);
    }

    public static synchronized LJAccount createJournal(boolean cyrillic, boolean isPaid, String name, Integer socCap) {
        LJAccount account = LJAccount.createJournal(cyrillic, isPaid, name, "test", socCap);
        generate(account);
        return account;
    }

    public static synchronized LJAccount createCommunity(String communityOwner, boolean cyrillic, boolean isPaid, String name, Integer socCap) {
        LJAccount account = LJAccount.createCommunity(communityOwner, cyrillic, isPaid, name, socCap);
        generate(account);
        return account;
    }

    public static synchronized void generate(LJAccount account) {
        try {
            String message = URLEncoder.encode(getRequestString(account), "UTF-8");
            URL url = new URL("http://" + ThucydidesUtils.getBaseUrl() + "/dev/user");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
                writer.write(message);
            }
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                System.out.println("=======================================================1");
                String response = readStreamToString(connection.getInputStream(), "UTF-8");
                System.out.println(response);
                System.out.println("=======================================================2");
            } else {
                Assert.fail("Connection is broken! Pesponse code: " + connection.getResponseCode());
            }
        } catch (MalformedURLException e) {
            Assert.fail("Cannot generate account!" + e);
        } catch (IOException e) {
            Assert.fail("Cannot generate account!" + e);
        }
    }

    private static synchronized String getRequestString(LJAccount account) {
        String message = "journaltype=";
        if (account.getJournalType().equals(JournalType.PERSONAL)) {
            message += "P";
        } else {
            message += "C";
        }

        message += "&comm_owner=";
        if (account.getJournalType().equals(JournalType.COMMUNITY)) {
            message += account.getCommunityOwner();
        }

        message += "&cyrillic=";
        if (account.isCyrillic()) {
            message += "1";
        } else {
            message += "0";
        }

        message += "&paid=";
        if (account.isPaid()) {
            message += "1";
        } else {
            message += "0";
        }

        message += "&username=" + account.getName()
                + "&soccap=" + account.getSocCap();
        return message;
    }

    private static synchronized String readStreamToString(InputStream in, String encoding) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(in, encoding)) {
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
        }
        return builder.toString();
    }
}
