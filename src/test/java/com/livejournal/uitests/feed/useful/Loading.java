

package com.livejournal.uitests.feed.useful;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import org.jbehave.core.annotations.Given;

/**
 *
 * @author m.prytkova
 */
public class Loading extends WebTest{
    
    @Given ("user (name $name) with underscope in name on the Friends Feed")
    public void user_with_underscope_in_name_on_the_Friends_Feed (String name){
        open(LoginPageUnlogged.class)
                .authorizeBy(name, workWithDB().getUserPassword(name));
        open(FriendsFeedLogged.class)
                .openSettings()
                .setPaging(name)
                .setSize(name)
                .saveSettings();
    }
    
}
