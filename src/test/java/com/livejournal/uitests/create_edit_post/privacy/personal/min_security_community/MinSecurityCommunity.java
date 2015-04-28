package com.livejournal.uitests.create_edit_post.privacy.personal.min_security_community;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import com.livejournal.uitests.utility.RandomText;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author m.panferova
 */
public class MinSecurityCommunity extends WebTest {

    //Scenario: Min security in creating post in community (1/3)
    @Given("logged user $name on Security page for community $community")
    public void logged_user_on_Security_page(String name, String community) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name);
        open(SettingsMainPage.class, new Url().setPostfix("?authas=" + community + "&cat=privacy"));
    }

    //Scenario: Min security in editing post in community (1/3)
    @Given("logged user $name with min security $security on Create Post page in community $community")
    public void logged_user_with_min_security_on_Create_Post_page_in_community(String name, String community, String security) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name);
        open(SettingsMainPage.class, new Url().setPostfix("?authas=" + community + "&cat=privacy"))
                .setMinSecurity(security)
                .saveSettings();
        open(UpdateBmlPageLogged.class);
    }

    //Scenario: Min security in creating post in community (2/3)
    @When("user set min security $security in the community $community")
    public void user_set_min_security(String security, String community) {
        onOpened(SettingsMainPage.class)
                .selectWorkAsUser(community)
                .clickSwitchJournalType()
                .setMinSecurity(security)
                .saveSettings();
    }

    //Min security in editing post in community (2/3)
    @When("user create new post with privacy $security in community $community")
    public void user_create_new_post_with_privacy(String security, String community) {
        ArrayList<String> g = new ArrayList<String>();
        onOpened(UpdateBmlPageLogged.class)
                .closeDraft()
                .postInCommunity()
                .selectCommunity(community)
                .createPost("", "html", RandomText.getRandomText(30))
                .setPrivacy(security, g)
                .postEntry();
    }

    //Scenario: Min security in creating post in community (3/3)
    @Then("user can set only allowed security $security when create post in community $community")
    public void user_can_set_only_allowed_security_when_create_post(String security, String community) {
        ArrayList<String> privacy = open(UpdateBmlPageLogged.class)
                .closeDraft()
                .postInCommunity()
                .selectCommunity(community)
                .getAllPrivacy();
        verify().that(correctPrivacy(security).equals(privacy))
                .ifResultIsExpected("Privacy is correct " + correctPrivacy(security).get(0))
                .ifElse("Privacy is in correct " + privacy.get(0))
                .finish();
    }

    //Scenario: Min security in editing post in community (3/3)
    @Then("user see all privacy when edit this post (security $security)")
    public void user_see_all_privacy_when_edit_this_post(String security) {
        ArrayList<String> privacy = onOpened(EntryPage.class)
                .clickOnEditButton()
                .getAllPrivacy();
        verify().that(correctPrivacy("public").equals(privacy))
                .ifResultIsExpected("Privacy is correct " + correctPrivacy("public").get(0))
                .ifElse("Privacy is in correct " + privacy.get(0))
                .finish();
    }

    ////////////////////////////////////////////
    private ArrayList<String> correctPrivacy(String privacy) {
        ArrayList<String> okPrivacy = new ArrayList<>();
        switch (AllowPrivacyCommunity.valueOf(privacy.toUpperCase())) {
            case PUBLIC:
                okPrivacy.add("Public");
                okPrivacy.add("Members");
                okPrivacy.add("Custom");
                okPrivacy.add("Maintainers");
                break;
            case MEMBERS:
                okPrivacy.add("Members");
                okPrivacy.add("Custom");
                okPrivacy.add("Maintainers");
                break;
            default:
                Assert.fail("Unknown privacy " + privacy + "!");
        }
        return okPrivacy;
    }

}
