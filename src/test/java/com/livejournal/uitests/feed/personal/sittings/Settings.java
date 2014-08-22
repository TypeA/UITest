package com.livejournal.uitests.feed.personal.sittings;

import com.livejournal.uisteps.core.FileLoader;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings.SettingsBubbleBackgroundBlock;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPage;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageForUnsignedInUser;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class Settings extends WebTest {

    @Given("logged user (name $name, password $password) on Friends Feed")
    public void logged_user_on_Friends_Feed(String name, String password) {
        on(LoginPage.class).authorizeBy(name, password);
        this.
        on(FriendsFeedLogged.class);
    }
    
    @When("user load Background image $image and set repeat $repeat in Settings and save it")
     public void user_load_Background_image_and_set_repeat_in_Settings_and_save_it(String repeat) throws InterruptedException{
         on(FriendsFeedLogged.class).getSupportButtonBlock().getSettings().click();
         on(FriendsFeedLogged.class).getSettingsBlock().getFeedSettingsBlock().getBackgroundImage().click();
         //on(SettingsBubbleBackgroundBlock.class).uploadBackgroundImage("C:\\Tests\\UITests\\src\\test\\java\\com\\livejournal\\uitests\\feed\\personal\\sittings\\загруженное.jpg");
      //   Thread.sleep(5000);
     }

}
