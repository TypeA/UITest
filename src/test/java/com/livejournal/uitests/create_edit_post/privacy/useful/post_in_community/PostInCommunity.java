package com.livejournal.uitests.create_edit_post.privacy.useful.post_in_community;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.journal_pages.EntryPage;
import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.update.EditJournalbml;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import static com.livejournal.uitests.utility.ParseString.getParsedString;
import com.livejournal.uitests.utility.RandomText;
import static com.livejournal.uitests.utility.EqualityOfArrayLists.isEqual;
import java.util.ArrayList;
import net.thucydides.core.annotations.StepGroup;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.panferova
 */
public class PostInCommunity extends WebTest {

    //Scenario: Create post in community (1/4)
    //Scenario: Edit post in community (1/4)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name);
        ThucydidesUtils.putToSession("user", name);
    }

    //Scenario: Create post in community (2/4)
    //Scenario: Edit post in community (2/4)
    @When("user create new post with privacy $privacy (group $group) in community $community")
    public void user_create_new_post_with_privacy_in_community(String privacy, String group, String community) {
        String postText = RandomText.getRandomText(30);
        onOpened(LoginPageUnlogged.class)
                .defaultMinSecurity(community);
        open(UpdateBmlPageLogged.class)
                .closeDraft()
                .postInCommunity()
                .selectCommunity(community)
                .createPost("", "html", postText)
                .setPrivacy(privacy, getParsedString(group, ";"))
                .postEntry();
        String postfix = getCurrentBrowser().getDriver().getCurrentUrl();
        postfix = postfix.replace("livejournal.ru/", "!");
        ThucydidesUtils.putToSession("post_link", postfix.substring(postfix.indexOf("!") + 1));
        ThucydidesUtils.putToSession("post_text", postText);
        ThucydidesUtils.putToSession("friend_group", group);
    }

    //Scenario: Edit post in community (3/4)
    @When("user edit privacy $privacy_1 (group $group_1) and save post in community $community")
    public void user_edit_privacy_and_save_post_in_community(String privacy_1, String group_1, String community) {
        open(EntryPage.class, new Url()
                .setPrefix(community + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        onOpened(EntryPage.class)
                .clickOnEditButton();
        onOpened(EditJournalbml.class).setPrivacy(privacy_1, getParsedString(group_1, ";"))
                .saveEntry();
    }

    //Scenario: Create post in community (3/4)
    @Then("user $name_1 can read the post in community $community")
    public void user_can_read_the_post(String name_1, String community) {
        open(MainPageLogged.class)
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut();
        String user = selectUserForComminuty(community, name_1, ThucydidesUtils.getFromSession("friend_group").toString());
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        open(EntryPage.class, new Url()
                .setPrefix(community + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        String postText = ThucydidesUtils.getFromSession("post_text").toString();
        verify().that(postText.contains(onOpened(EntryPage.class).getPostText()))
                .ifResultIsExpected("User can see post '" + postText + "'")
                .ifElse("User cannot see post '" + postText + "', but see '" + onOpened(EntryPage.class).getPostText() + "'")
                .finish();
        open(MainPageLogged.class)
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut();
    }

    //Scenario: Create post in community (4/4)
    @Then("user $name_2 cannot read the post in community $community")
    public void user_cannot_read_post_in_comminuty(String name_2, String community) {
        if (name_2.isEmpty()) {
            verify().that(true)
                    .ifResultIsExpected("All user can see post")
                    .ifElse("")
                    .finish();
        } else {
            String user = selectUserForComminuty(community, name_2, ThucydidesUtils.getFromSession("friend_group").toString());
            open(LoginPageUnlogged.class)
                    .authorizeBy(user, getDBDate().userData().getUserPassword(user));
            open(MyJournalPage.class, new Url()
                    .setPrefix(community + ".")
                    .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
            String error = getCurrentBrowser()
                    .getDriver()
                    .getTitle();
            verify().that(error.contains("Access is closed"))
                    .ifResultIsExpected("User can see error 'Access is closed'")
                    .ifElse("User cannot see error 'Access is closed!', but see '" + error + "'")
                    .finish();
        }
    }

    //Scenario: Edit post in community (4/4)
    @Then("user see correct privacy $privacy_1 (group $group_1) when edit this post in community $community")
    public void user_see_correct_privacy_when_edit_this_post_in_community(String privacy_1, String group_1, String community) {
        open(EntryPage.class, new Url()
                .setPrefix(community + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        onOpened(EntryPage.class).clickOnEditButton();
        verify().that(isEqual(getParsedString(onOpened(EditJournalbml.class).getCurrentPrivacy(), "\\n"), getParsedString(privacy_1 + ";" + group_1, ";")))
                .ifResultIsExpected("User see correct privacy " + privacy_1 + " " + group_1)
                .ifElse("User see incorrect privacy " + onOpened(EditJournalbml.class).getCurrentPrivacy())
                .finish();
    }

////////////////////////////////////////////////////////
    @StepGroup
    private String selectUserForComminuty(String community, String name, String group) {
        switch (SelectUserForCommunity.valueOf(name.toUpperCase())) {
            case MEMBERS:
                String ans = getDBDate().community().findMemberInCommunityNotInGroup(community);
                return ans;
            case MAINTAINERS:
                return getDBDate().community().findMaintainerInComminuty(community);
            case USER_IN_GROUP:
                ArrayList<String> in_group = getDBDate().friends().findFriendInGroup(community, group);
                String user_in_group = getDBDate().friends().findFriendInGroup(community, group).get(0);
        for (String in_group1 : in_group) {
            if (in_group1.contains("test")) {
                user_in_group = in_group1;
            }
        }
                return user_in_group;
            case OTHER_USER:
                return getDBDate().friends().findNotFriend(community);
            default:
                String user2 = ThucydidesUtils.getFromSession("user").toString();
                return user2;
        }

    }

}
