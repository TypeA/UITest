package com.livejournal.uitests.create_edit_post.privacy.useful.post_in_community;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.entry.EntryPageLogged;
import com.livejournal.uitests.pages.journal_pages.journal.MyJournalPageLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.update.EditJournalBml;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import java.io.IOException;
import java.util.ArrayList;
import net.thucydides.core.annotations.StepGroup;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.panferova
 */
public class PostInCommunity extends LJTest {

    //Scenario: Create post in community (1/4)
    //Scenario: Edit post in community (1/4)
    @Given("logged user $name on Create Post page")
    public void logged_user_on_Create_Post_page(String name) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultLanguageLogged(name);
        ThucydidesUtils.putToSession("user", name);
    }

    //Scenario: Create post in community (2/4)
    //Scenario: Edit post in community (2/4)
    @When("user create new post with privacy $privacy (group $group) in community $community")
    public void user_create_new_post_with_privacy_in_community(String privacy, String group, String community) throws IOException {
        String postText = utility().random().getRandomText(30);
        onOpened(LoginPageUnlogged.class)
                .setDefault().defaultMinSecurity(community);
        String post_link = open(UpdateBmlPageLogged.class)
                .closeDraft()
                .selectCommunity(community)
                .usePostContent()
                .setPostText(postText, "html")
                .setPrivacy(privacy, utility().convertation().stringToList(group, ";"))
                .usePage()
                .postEntry()
                .getIdPost(community);
        ThucydidesUtils.putToSession("post_text", postText);
        ThucydidesUtils.putToSession("friend_group", group);
        ThucydidesUtils.putToSession("post_link", post_link);
    }

    //Scenario: Edit post in community (3/4)
    @When("user edit privacy $privacy_1 (group $group_1) and save post in community $community")
    public void user_edit_privacy_and_save_post_in_community(String privacy_1, String group_1, String community) {
        open(EntryPageLogged.class, new Url()
                .setPrefix(community + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        onOpened(EntryPageLogged.class)
                .Entry()
                .clickOnEditButton();
        onOpened(EditJournalBml.class)
                .usePostContent()
                .setPrivacy(privacy_1, utility().convertation().stringToList(group_1, ";"))
                .onOpened(EditJournalBml.class)
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
                .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                .style().setViewInMyStyle(user, false);
        open(EntryPageLogged.class, new Url()
                .setPrefix(community + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        String postText = ThucydidesUtils.getFromSession("post_text").toString();
        verify().that(postText.contains(onOpened(EntryPageLogged.class).Entry().getPostText()))
                .ifResultIsExpected("User can see post '" + postText + "'")
                .ifElse("User cannot see post '" + postText + "', but see '" + onOpened(EntryPageLogged.class).Entry().getPostText() + "'")
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
                    .authorizeBy(user, getDBDate().userData().getUserPassword(user))
                    .style().setViewInMyStyle(user, false);
            open(MyJournalPageLogged.class, new Url()
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
        open(EntryPageLogged.class, new Url()
                .setPrefix(community + ".")
                .setPostfix(ThucydidesUtils.getFromSession("post_link").toString()));
        onOpened(EntryPageLogged.class).Entry().clickOnEditButton();
        verify().that(utility().verification().sameArrayLists(utility().convertation().stringToList(onOpened(EditJournalBml.class).usePostContent().getCurrentPrivacy(), "\\n"), utility().convertation().stringToList(privacy_1 + ";" + group_1, ";")))
                .ifResultIsExpected("User see correct privacy " + privacy_1 + " " + group_1)
                .ifElse("User see incorrect privacy " + onOpened(EditJournalBml.class).usePostContent().getCurrentPrivacy())
                .finish();
    }


    @StepGroup
    private String selectUserForComminuty(String community, String name, String group) {
        switch (SelectCommunityUserList.valueOf(name.toUpperCase())) {
            case MEMBERS:
                String ans = getDBDate().community().findMemberInCommunityNotInGroup(community);
                return ans;
            case MAINTAINERS:
                return getDBDate().community().findMaintainerInComminuty(community);
            case USER_IN_GROUP:
                ArrayList<String> in_group = getDBDate().friends().getAllFriendsInGroup(community, group);
                String user_in_group = getDBDate().friends().getAllFriendsInGroup(community, group).get(0);
                for (String in_group1 : in_group) {
                    if (in_group1.contains("test")) {
                        user_in_group = in_group1;
                    }
                }
                return user_in_group;
            case OTHER_USER:
                return getDBDate().friends().getNotFriend(community);
            default:
                String user2 = ThucydidesUtils.getFromSession("user").toString();
                return user2;
        }

    }

}
