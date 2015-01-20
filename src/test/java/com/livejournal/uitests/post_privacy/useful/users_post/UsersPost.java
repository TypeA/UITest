package com.livejournal.uitests.post_privacy.useful.users_post;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.utility.RandomName;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.JavascriptExecutor;

/**
 *
 * @author m.prytkova
 */
public class UsersPost extends WebTest {

    //Scenario: Create post (1/4)
    @Given("logged user (name $name, password $password) on Create Post page")
    public void logged_user_on_Create_Post_page(String name, String password) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, password);
        open(UpdateBmlPageLogged.class);
        ThucydidesUtils.putToSession("user", name);
    }

    //Scenario: Create post (2/4)
    @When("user create new post with privacy $privacy")
    public void user_create_new_post_with_privacy(String privacy) {
        String postText = new RandomName("post test rnd").get();
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .createPost("", "html", postText)
                .setPrivacy(privacy)
                .postEntry();
        String postfix = getCurrentBrowser().getDriver().getCurrentUrl();
        postfix = postfix.replace("livejournal.ru/", "!");
        ThucydidesUtils.putToSession("post_link", postfix.substring(postfix.indexOf("!") + 1));
        ThucydidesUtils.putToSession("post_text", postText);
    }

    //Scenario: Create post (3/4)
    @Then("user (name $name_1, password $password_1) can read the post")
    public void user_can_read_post(String name_1, String password_1) throws InterruptedException {
        String script = "return jQuery('.b-singlepost-body.entry-content.e-content')[0].textContent";
        try {
            ((JavascriptExecutor) getCurrentBrowser().getDriver()).executeScript(script);
            ThucydidesUtils.putToSession("script", script);
        } catch (Exception ex) {
            ThucydidesUtils.putToSession("script", "return jQuery('.j-e-text')[0].textContent");
        }
        open(MainPageLogged.class)
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut();
        if (name_1.isEmpty()) {
        } else {
            open(LoginPageUnlogged.class)
                    .authorizeBy(name_1, password_1);}
            open(MyJournalPage.class, new Url()
                    .setPrefix(ThucydidesUtils.getFromSession("user").toString() + ".")
                    .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
            String postText = ThucydidesUtils.getFromSession("post_text").toString();
            verify().that(postText.equals(startScript(ThucydidesUtils.getFromSession("script").toString()).toString().trim()))
                    .ifResultIsExpected("User can see post '" + postText + "'")
                    .ifElse("User cannot see post '" + postText + "', but see '" + startScript(ThucydidesUtils.getFromSession("script").toString()).toString() + "'")
                    .finish();
            open(MainPageLogged.class)
                    .moveMouseOverMyJournalMenuItem()
                    .clickOnLogOut();
        
    }

    //Scenario: Create post (4/4)
    @Then("user (name $name_2, password $password_2) cannot read the post")
    public void user_cannot_read_post(String name_2, String password_2) throws InterruptedException {
        if (name_2.isEmpty()) {
            verify().that(true)
                    .ifResultIsExpected("All user can see post")
                    .ifElse("")
                    .finish();
        } else {
            open(LoginPageUnlogged.class)
                    .authorizeBy(name_2, password_2);
            open(MyJournalPage.class, new Url()
                    .setPrefix(ThucydidesUtils.getFromSession("user").toString() + ".")
                    .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
            String error = getCurrentBrowser()
                    .getDriver()
                    .getTitle();
            verify().that(error.contains("Access is closed"))
                    .ifResultIsExpected("User can see error '" + error + "'")
                    .ifElse("User cannot see error 'Access is closed!', but see '" + error + "'")
                    .finish();
        }
    }

}
