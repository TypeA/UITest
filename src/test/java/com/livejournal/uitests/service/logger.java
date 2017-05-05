package com.livejournal.uitests.service;

import com.livejournal.uitests.LJTest;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.logging.LogEntry;

import java.util.logging.Level;

/**
 * Created by sergey.savinykh on 05.05.17.
 */
public class logger extends LJTest {

    //Scenario: Logger for unlogged user(1/2)
    @Given("unlogged user on page $page with url $url")
    public void unlogged_user_on_page_with_url(String page,String url) {
        openUrl(url);
    }

    //Scenario: Logger for unlogged user(2/2)
    @Then("user get logs from dev console")
    public void user_get_logs_from_dev_console() {
        String logs = getLogs();
        verify().that(logs.isEmpty())
                .ifResultIsExpected("There is no errors in console")
                .ifElse("Errors log: " + logs)
                .finish();
    }

    private String getLogs() {
        String allLogs = "";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            for (LogEntry log : getCurrentBrowser().getDriver().manage().logs().get("browser").filter(Level.SEVERE)) {
                allLogs += log.toString() + "\n";
            }
        }
        return allLogs;
    }

}
