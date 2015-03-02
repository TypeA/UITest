package com.livejournal.uitests.create_post.useful.post_time;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import com.livejournal.uitests.pages.service_pages.update.FinishPostForm;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.utility.RandomText;
import com.livejournal.uitests.utility.date.Date;
import com.livejournal.uitests.utility.date.DateType;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class PostTime extends WebTest {

    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, workWithDB().getUserPassword(name))
                .defoultLanguage(name);
        open(SheduledEntriesPage.class)
                .deleteAllSheduledEntries();
        open(UpdateBmlPageLogged.class);
    }

    @When("user create new post and change parameter $parameter by value $value")
    public void user_create_new_post_and_change_date(String parameter, String value) {
        ThucydidesUtils.putToSession("post_date", getCorrectDate(parameter, value));
        String[] date = ThucydidesUtils
                .getFromSession("post_date")
                .toString()
                .split(";");
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .createPost("New scheduled post", "html", post_text)
                .setDateAndTime(date[0], date[1])
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text);
    }

    @Then("the post is scheduled")
    public void the_post_is_scheduled() {
        String post_text = onDisplayed(FinishPostForm.class)
                .clickToScheduledLink()
                .getPostByText(ThucydidesUtils.getFromSession("post_text").toString().trim());
        verify().that(post_text.contains(convertPostTime(ThucydidesUtils.getFromSession("post_date").toString())))
                .ifResultIsExpected("Post is scheduled, whis correct date: " + convertPostTime(ThucydidesUtils.getFromSession("post_date").toString()))
                .ifElse("There is no post " + post_text + " in scheduled, with correct date")
                .finish();
    }

    ///////////////////////////////
    private String getCorrectDate(String parameter, String value) {
        Integer day = Date.getCurrentDay();
        Integer month = Date.getCurrentMonth();
        Integer year = Date.getCurrentYear();
        Integer hour = Date.getCurrentTime("hour") - 1;
        Integer min = Date.getCurrentTime("min");

        switch (DateType.valueOf(parameter.toUpperCase())) {
            case DAY:
                day = day + Integer.valueOf(value);
                if (day > 28) {
                    day = 1;
                    month = month + 1;
                }
                if (day < 1) {
                    day = 1;
                    month = month - 1;
                }
                break;
            case MONTH:
                month = month + Integer.valueOf(value);
                if (month > 12) {
                    month = 1;
                    year = year + 1;
                }
                if (month < 1) {
                    month = 1;
                    year = year - 1;
                }
                break;
            case YEAR:
                year = year + Integer.valueOf(value);
                break;
            case HOUR:
                hour = hour + Integer.valueOf(value);
                if (hour > 23) {
                    hour = 23;
                }
                if (hour < 0) {
                    hour = 0;
                }
                break;
            case MIN:
                min = min + Integer.valueOf(value);
                if (min > 59) {
                    min = 59;
                }
                if (min < 0) {
                    min = 0;
                }
                break;
            default:
                break;
        }

        String dop_month = "";
        String dop_day = "";
        String dop_min = "";
        if (month.toString().length() == 1) {
            dop_month = "0";
        }
        if (day.toString().length() == 1) {
            dop_day = "0";
        }
        if (min.toString().length() == 1) {
            dop_min = "0";
        }
        return dop_month + month + "/" + dop_day + day + "/" + year + ";" + hour + ":" + dop_min + min;
    }

    private String convertPostTime(String time) {
        return Date.getManthByIndex(time.substring(0, 2))
                + " " + time.substring(3, 5)
                + ", " + time.substring(6, 10)
                + ", " + time.substring(11, 16);
    }
}
