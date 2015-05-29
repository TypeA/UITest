package com.livejournal.uitests.create_edit_post.login_form.useful.login_form;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.utility.RandomText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class LoginForm extends WebTest {

    //Scenario: Logged user create new post (1/3)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name);
        System.out.println("==================1");
        open(UpdateBmlPageLogged.class);
        System.out.println("==================2");
    }

    //Scenario: Logged user create new post (2/3)
    @When("user create new post")
    public void user_create_new_post_and_change_date(String parameter, String value) {
        System.out.println("==================3");
        ThucydidesUtils.putToSession("post_text", RandomText.getRandomText(30));
   
        System.out.println("==================4");

        
    }

    //Scenario: Logged user create new post (3/3)
    @Then("the post is in journal")
    public void the_post_is_in_journal() {

    }

}
