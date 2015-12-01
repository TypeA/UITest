package com.livejournal.uitests.feed.useful.composition;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import java.util.ArrayList;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

/**
 *
 * @author m.prytkova
 */
public class Composition extends LJTest {

    //Scenario: Privacy (1/3)
    @Given("user $user which create post with privacy $privacy (group $group)")
    public void user_which_create_post_with_privacy(String user, String privacy, String group) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        String postSudject = utility().random().getRandomText(20);
        open(UpdateBmlPageLogged.class)
                .closeDraft()
                .usePostContent()
                .setSubject(postSudject)
                .setPostText(utility().random().getRandomText(40), "html")
                .setPrivacy(privacy, utility().convertation().stringToList(group, ";"))
                .usePage()
                .postEntry();
        ThucydidesUtils.putToSession("user", user);
        ThucydidesUtils.putToSession("post_link", getCurrentBrowser().getCurrentUrl());
        ThucydidesUtils.putToSession("group", group);
        ThucydidesUtils.putToSession("post_subject", postSudject);
    }

    //Scenario: Privacy(2/3)
    @Then("user $user1 can see the post on the Friends Feed")
    public void user_can_see_post_on_Feed(String user1) {
        if (!user1.equals("nobody")) {
            String type = user1;
            open(MainPageLogged.class)
                    .moveMouseOverMyJournalMenuItem()
                    .clickOnLogOut();
            user1 = selectFriend(ThucydidesUtils.getFromSession("user").toString(), type, ThucydidesUtils.getFromSession("group").toString());
            open(LoginPageUnlogged.class)
                    .authorizeBy(user1, getDBDate().userData().getUserPassword(user1));
            boolean post_in_feed = open(FriendsFeedLogged.class, new Url().setPrefix(user1 + "."))
                    .feed()
                    .postInFeedBySubject(ThucydidesUtils.getFromSession("post_subject").toString());
            verify().that(post_in_feed)
                    .ifResultIsExpected("User '" + type + "' see post in his feed")
                    .ifElse("User " + user1 + " '" + type + "' cannot see post \n'"
                            + ThucydidesUtils.getFromSession("post_subject") + "' \nin his feed")
                    .finish();
        }

    }

    //Scenario: Privacy (3/3)
    @Then("user $user2 cannot see the post on the Friends Feed")
    public void user_cannot_see_post_on_Feed(String user2) {
        String type = user2;
        open(MainPageLogged.class)
                .moveMouseOverMyJournalMenuItem()
                .clickOnLogOut();
        user2 = selectFriend(ThucydidesUtils.getFromSession("user").toString(), type, ThucydidesUtils.getFromSession("group").toString());
        open(LoginPageUnlogged.class)
                .authorizeBy(user2, getDBDate().userData().getUserPassword(user2));
        boolean post_in_feed = open(FriendsFeedLogged.class, new Url().setPrefix(user2 + "."))
                .feed()
                .postInFeedBySubject(ThucydidesUtils.getFromSession("post_subject").toString());
        verify().that(!post_in_feed)
                .ifResultIsExpected("User '" + type + "' cannot see post in his feed")
                .ifElse("User " + user2 + " '" + type + "' see post \n'"
                        + ThucydidesUtils.getFromSession("post_subject") + "' \nin his feed")
                .finish();
    }

    private String selectFriend(String user, String type, String group) {
        ArrayList<String> in_group = new ArrayList<String>();
        ArrayList<String> friends = new ArrayList<String>();
        ArrayList<String> follower = getDBDate().friends().getAllFllowers(user);
        switch (type.toUpperCase()) {
            case "NOT_FOLLOWER":
                return getDBDate().friends().getNotFollower(user);
            case "FOLLOWER":
                return getDBDate().friends().getFollower(user);
            case "FRIEND":
                friends = getDBDate().friends().getAllFriends(user);
                for (String friend : friends) {
                    for (String follower1 : follower) {
                        if (friend.equals(follower1)) {
                            return friend;
                        }
                    }
                }
            case "NOT_FRIEND":
                friends = getDBDate().friends().getAllFriends(user);
                follower.removeAll(friends);
                return actualUser(follower);
            case "IN_GROUP":
                in_group = getDBDate().friends().getAllFriendsInGroup(user, group);
                for (String in_group1 : in_group) {
                    for (String follower1 : follower) {
                        if (in_group1.equals(follower1)) {
                            return in_group1;
                        }
                    }
                }
            case "NOT_IN_GROUP":
                in_group = getDBDate().friends().getAllFriendsInGroup(user, group);
                follower.removeAll(in_group);
                return actualUser(follower);
            default:
                return user;
        }
    }

    private String actualUser(ArrayList<String> users) {
        for (String user : users) {
            if (user.contains("test")) {
                return user;
            }
        }
        return null;
    }

}
