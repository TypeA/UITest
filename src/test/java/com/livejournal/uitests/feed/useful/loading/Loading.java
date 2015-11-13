package com.livejournal.uitests.feed.useful.loading;

import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class Loading extends LJTest {

    @Given("user $user with paging type $type on the Friends Feed")
    public void user_with_underscope_in_name_on_the_Friends_Feed(String user, String type) {
        open(LoginPageUnlogged.class)
                .authorizeBy(user, getDBDate().userData().getUserPassword(user));
        String user_paging_type = getDBDate().userSettings().getFeedPaging(user, "type");
        if (!user_paging_type.equals(type)) {
            open(FriendsFeedLogged.class)
                    .openSettings()
                    .setPaging(getDBDate().userSettings().getFeedPaging(user, "type"))
                    .setSize(10)
                    .saveSettings();
            getCurrentBrowser().refreshCurrentPage();
        }
    }

    @When("user scroll Friends Feed down")
    public void user_scroll_Friends_Feed_down() {
    }

}
