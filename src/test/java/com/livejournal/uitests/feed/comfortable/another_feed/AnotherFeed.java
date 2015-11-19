package com.livejournal.uitests.feed.comfortable.another_feed;

import com.livejournal.uitests.LJTest;
import junit.framework.Assert;
import org.jbehave.core.annotations.Given;

/**
 *
 * @author m.prytkova
 */
public class AnotherFeed extends LJTest {

    @Given("user $user on user2 $user2 Friends Feed")
    public void user_on_user2_Feed(String user, String user2) {
        Assert.assertTrue("Incorrect user: without friends", userWithFriends(user));
    }

    private void userWithGroups(String user) {
    }
}
