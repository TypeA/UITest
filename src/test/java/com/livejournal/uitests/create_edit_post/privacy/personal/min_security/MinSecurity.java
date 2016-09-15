package com.livejournal.uitests.create_edit_post.privacy.personal.min_security;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author m.prytkova
 */
public class MinSecurity extends LJTest {

    //Scenario: Min security in creating post(1/3)
    @Given("logged user $name on Security page")
    public void logged_user_on_Security_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultLanguageLogged(name);
        open(SettingsMainPage.class, new Url().setPostfix("?cat=privacy"));
    }

    //Scenario: Min security in editing post(1/3)
    @Given("logged user $name with min security $security on Create Post page")
    public void logged_user_with_min_security_on_Create_Post_page(String name, String security) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultLanguageLogged(name);
        open(SettingsMainPage.class, new Url().setPostfix("?cat=privacy"))
                .setMinSecurity(security)
                .saveSettings();
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: Min security in creating post(2/3)
    @When("user set min security $security")
    public void user_set_min_security(String security) {
        onOpened(SettingsMainPage.class)
                .setMinSecurity(security)
                .saveSettings();
    }

    //Scenario: Min security in editing post(2/3)
    @When("user create new post with privacy $security")
    public void user_create_new_post_with_privacy(String security) {
        ArrayList<String> g = new ArrayList<String>();
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .setPostText(utility().random().getRandomText(30), "html")
                .setPrivacy(security, g)
                .usePage()
                .postEntry();
    }

    //Scenario: Min security in creating post(3/3)
    @Then("user can set only allowed security $security when create post")
    public void user_can_set_only_allowed_security_when_create_post(String security){
        ArrayList<String> privacy = open(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .getAllPrivacy();
        verify().that(correctPrivacy(security).equals(privacy))
                .ifResultIsExpected("Privacy is correct " + correctPrivacy(security).get(0))
                .ifElse("Privacy is in correct " + privacy.get(0))
                .finish();
    }

    //Scenario: Min security in editing post(3/3)
    @Then("user see all privacy when edit this post")
    public void user_see_all_privacy_when_edit_this_post() {
        ArrayList<String> privacy = onOpened(EntryPageLogged.class)
                .Entry()
                .clickOnEditButton()
                .usePostContent()
                .getAllPrivacy();
        verify().that(correctPrivacy("public").equals(privacy))
                .ifResultIsExpected("Privacy is correct " + correctPrivacy("public").get(0))
                .ifElse("Privacy is in correct " + privacy.get(0))
                .finish();
    }

    ////////////////////////////////////////////
    private ArrayList<String> correctPrivacy(String privacy) {
        ArrayList<String> okPrivacy = new ArrayList<>();
        switch (privacy.toUpperCase()) {
            case "PUBLIC":
                okPrivacy.add("Public");
                okPrivacy.add("Friends");
                okPrivacy.add("Custom");
                okPrivacy.add("Private");
                break;
            case "FRIENDS":
                okPrivacy.add("Friends");
                okPrivacy.add("Custom");
                okPrivacy.add("Private");
                break;
            case "PRIVATE":
                okPrivacy.add("Private");
                break;
            default:
                Assert.fail("Unknown privacy " + privacy + "!");
        }
        return okPrivacy;
    }

}
