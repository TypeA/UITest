package com.livejournal.uitests.create_edit_post.time.comfortable.scheduled_post_additional_parameters;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.utility.RandomText;
import com.livejournal.uitests.utility.date.PostTime;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class ScheduledPostAdditionalParameters extends WebTest {

    //Scenario: Create scheduled post with additional parametrs (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .defaultStyle(name);
        open(SheduledEntriesPage.class)
                .deleteAllSheduledEntries();
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: Create scheduled post with additional parametrs (2/3)
    @When("user create new post and change parameter $parameter by value $value")
    public void user_create_new_post_and_change_parameter_by_value(String parametr, String value) {
        String[] date = PostTime.getCorrectDate("hour", "1")
                .split(";");
        String post_text = RandomText.getRandomText(30);
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .createPost("New scheduled post with additional parametrs", "html", post_text)
                .setDateAndTime(date[0], date[1])
                .postEntry();
        ThucydidesUtils.putToSession("post_text", post_text.trim());
    }
}
