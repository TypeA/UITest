package com.livejournal.uitests.friends.useful.the_banned_user;

import com.livejournal.uisteps.thucydides.ThucydidesUtils;
import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.settings.BannedUsersPage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author m.panferova
 */
public class TheBannedUser extends WebTest {

    //Scenario: Ban User(1/3)
    //Scenario: Unban user(1/3)
    @Given("logged user (name $name) on BannedUsersPage")
    public void logged_user_on_BannedUsersPage(String name) {
        ThucydidesUtils.putToSession("user", name);
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name));
        open(BannedUsersPage.class);
    }

    //Scenario: Ban User(2/3)
    @When("user ban one user_1 and save change")
    public void user_ban_one_user_1_and_save_change() {
        String user = ThucydidesUtils.getFromSession("user").toString();
        String user_1 = getDBDate().bannedUser().findUserNotInBannedList(user);
        onOpened(BannedUsersPage.class)
                .typeInBanList(user_1)
                .clickBannedUser();
        ThucydidesUtils.putToSession("user_1", user_1);
    }

    //Scenario: Ban User(3/3)
    @Then("user_1 exist in ban list")
    public void user_1_can_not_add_comment_for_user_post() {
        String user = ThucydidesUtils.getFromSession("user").toString();
        String user_1 = ThucydidesUtils.getFromSession("user_1").toString();
        verify().that(onOpened(BannedUsersPage.class).userInBanList(user_1))
                .ifResultIsExpected("User add to ban list")
                .ifElse("User not add to ban list")
                .finish();
    }

    //Scenario: Unban user(2/3)
    @When("user unban one user_1 and save change")
    public void user_unban_one_user_1_and_save_change() {
        String user = ThucydidesUtils.getFromSession("user").toString();
        String user_1 = getDBDate().bannedUser().findUserInBannedList(user);
        System.out.println(user_1 + "!!!!!!");
        chooseBanUser(user_1);
        onOpened(BannedUsersPage.class)
                .clickSaveChange();
        ThucydidesUtils.putToSession("user_1", user_1);
    }

    //Scenario: Unban user(3/3)
    @Then("user_1 does not exists in ban list")
    public void user_1_does_not_exists_in_ban_list() {
        String user_1 = ThucydidesUtils.getFromSession("user_1").toString();
        verify().that(!onOpened(BannedUsersPage.class).userInBanList(user_1))
                .ifResultIsExpected("User not in ban list")
                .ifElse("User in ban list")
                .finish();
        
    }
    //Scenario: Ban several users(2/3)
    @When("user ban several users and save change")
    public void user_ban_several_users_and_save_change() {
        String user = ThucydidesUtils.getFromSession("user").toString();
        String user_1 = getDBDate().bannedUser().findUserNotInBannedList(user);
        String user_2 = getDBDate().bannedUser().findUserNotInBannedList(user);
        int i = 0;
        while (user_1.equals(user_2)) {
            user_2 = getDBDate().bannedUser().findUserNotInBannedList(user);
            i = i + 1;
            if (i == 4) {
                break;
            }
        }
        String several_users = user_1 + "," + user_2;
        onOpened(BannedUsersPage.class)
                .typeInBanList(several_users)
                .clickBannedUser();
        ThucydidesUtils.putToSession("user_1", user_1);
        ThucydidesUtils.putToSession("user_2", user_2);
    }
    //Scenario: Ban several users(3/3)
    @Then("users exist in ban list")
    public void users_exist_in_ban_list() {
        String user_1 = ThucydidesUtils.getFromSession("user_1").toString();
        String user_2 = ThucydidesUtils.getFromSession("user_2").toString();
        verify().that(onOpened(BannedUsersPage.class).userInBanList(user_1))
                .ifResultIsExpected("User_1 add to ban list")
                .ifElse("User_1 not add to ban list")
                .and()
                .that(onOpened(BannedUsersPage.class).userInBanList(user_2))
                .ifResultIsExpected("User_2 add to ban list")
                .ifElse("User_2 not add to ban list")
                .finish();
    }
    //Scenario: Unban several users(2/3)
    @When("user unban several users and save change")
    public void user_unban_several_users_and_save_change() {
        String user = ThucydidesUtils.getFromSession("user").toString();
        String user_1 = getDBDate().bannedUser().findUserInBannedList(user);
        String user_2 = getDBDate().bannedUser().findUserInBannedList(user);
        int i = 0;
        while (user_1.equals(user_2)) {
            user_2 = getDBDate().bannedUser().findUserInBannedList(user);
            i = i + 1;
            if (i == 4) {
                break;
            }
        }
        chooseBanUser(user_1);
        chooseBanUser(user_2);
        onOpened(BannedUsersPage.class)
                .clickSaveChange();
        ThucydidesUtils.putToSession("user_1", user_1);
        ThucydidesUtils.putToSession("user_2", user_2);
    }
     //Scenario: Unban several users(3/3)
    @Then("users does not exist in ban list")
    public void users_does_not_exist_in_ban_list() {
        String user_1 = ThucydidesUtils.getFromSession("user_1").toString();
        verify().that(!onOpened(BannedUsersPage.class).userInBanList(user_1))
                .ifResultIsExpected("User_1 not in ban list")
                .ifElse("User_1 in ban list")
                .and()
                .that(!onOpened(BannedUsersPage.class).userInBanList(user_1))
                .ifResultIsExpected("User_2 not in ban list")
                .ifElse("User_2 in ban list")
                .finish();
    }
    
    public void chooseBanUser(String user_1) {
        WebDriver driver = getCurrentBrowser().getDriver();
        WebElement element = driver.findElement(By.xpath("//table//td//b[text()='" + user_1 + "']/ancestor::td/preceding-sibling::td//input"));
        element.click();
    }
    
}
