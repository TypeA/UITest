package com.livejournal.uitests;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.redis_data.RedisData;
import com.livejournal.uitests.databases_data.DatabasesData;
import com.livejournal.uitests.utility.Utility;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.openqa.selenium.logging.LogEntry;

public class LJTest extends WebTest {

    public DatabasesData getDBDate() {
        return new DatabasesData();
    }

    public RedisData getRedisDate() {
        return new RedisData();
    }

    public Utility utility() {
        return new Utility();
    }


    public List<ArrayList<String>> getLoggs() {

        LinkedHashSet<String> severe = new LinkedHashSet<String>();
        LinkedHashSet<String> warningerr = new LinkedHashSet<String>();
        for (LogEntry logEntry : getCurrentBrowser().getDriver().manage().logs().get("browser").getAll()) {
            if (logEntry.getLevel().toString().equals("SEVERE")) {
                severe.add(logEntry.getMessage());
            }
            if (logEntry.getLevel().toString().equals("WARNING")) {
                warningerr.add(logEntry.getMessage());
            }
        }

        ArrayList<String> severe_logs = new ArrayList<String>();
        ArrayList<String> warningerr_logs = new ArrayList<String>();

        for (String error : severe) {
            severe_logs.add(error);
        }

        for (String error : warningerr) {
            warningerr_logs.add(error);
        }

        List<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        ans.add(severe_logs);
        ans.add(warningerr_logs);

        return ans;
    }

}
