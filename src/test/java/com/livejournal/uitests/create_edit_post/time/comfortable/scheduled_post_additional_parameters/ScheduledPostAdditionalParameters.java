package com.livejournal.uitests.create_edit_post.time.comfortable.scheduled_post_additional_parameters;

import com.livejournal.uisteps.thucydides.WebTest;
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
    }

    //Scenario: Create scheduled post with additional parametrs (2/3)
    @When("user create new post and change parameter $parameter by value $value")
    public void user_create_new_post_and_change_parameter_by_value(String parametr, String value) {
    }
}
