package com.livejournal.uitests.navigation.useful.header_navigation;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.utility.VerifyText;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Cookie;

/**
 *
 * @author m.prytkova
 */
public class HeaderNavigation extends WebTest {

    //Scenario: Navigation for logged user (1/3)
    @Given("logged user (name $name, password $password) on Main Page")
    public void logged_user_on_Main_Page(String name, String password) {
        this.getCurrentBrowser().getDriver().manage().addCookie(new Cookie("fake_ipclass", "russia"));
        on(LoginPageUnlogged.class)
                .authorizeBy(name, password);
    }

    //Scenario: Navigation for unlogged user (1/3)   
    @Given("unlogged user on Main Page")
    public void unlogged_user_on_Main_Page() {
        this.getCurrentBrowser().getDriver().manage().addCookie(new Cookie("fake_ipclass", "russia"));
        on(MainPageUnlogged.class);
    }

    //Scenario: Navigation for logged user (2/3)
    @When("user goes from page $page using link $link")
    public void user_goes_from_page_using_link(String page, String link) {
        goToLink(page, HeaderLinksList.valueOf(link));
    }

    //Scenario: Navigation for unlogged user (2/3)
    @When("unlogged user goes from page $page using link $link")
    public void unlogged_user_goes_from_page_using_link(String page, String link) {
        goToLinkUnlogged(page, HeaderLinksList.valueOf(link));
    }

    //Scenario: Navigation for logged user (3/3)
    //Scenario: Navigation for unlogged user (3/3)
    @Then("user in correct page $correct_page with URL $URL")
    public void user_in_correct_Page_with_URL(String correct_page, String URL) {
        verify().that(getCurrentUrl().contains(URL))
                .ifResultIsExpected(VerifyText.okTextForURL(correct_page, URL))
                .ifElse(VerifyText.errorTextForURL(correct_page, URL, getCurrentUrl()))
                .finish();
    }

    private void goToLinkUnlogged(String pageName, HeaderLinksList link) {
        ServicePageUnlogged page = on(ServicePageUnlogged.class, pageName);
        switch (link) {
            case LOGO:
                page.clickOnLogo();
                break;
            case LJMAGAZINE:
                page.clickOnLjMagazineMenuItem();
                break;
            case SHOP:
                page.moveMouseOverShopMenuItem()
                        .clickOnShop();
                break;
            case PAID:
                page.moveMouseOverShopMenuItem()
                        .clickOnPaid();
                break;
            case PROMO:
                page.moveMouseOverShopMenuItem()
                        .clickOnPromo();
                break;
            case TOKENS:
                page.moveMouseOverShopMenuItem()
                        .clickOnTokensLink();
                break;
            case HELP:
                page.moveMouseOverHelpMenuItem()
                        .clickOnHelp();
                break;
            case ABOUT:
                page.moveMouseOverHelpMenuItem()
                        .clickOnAbout();
                break;
            case FAQ:
                page.moveMouseOverHelpMenuItem()
                        .clickOnFaq();
                break;
            case TOS:
                page.moveMouseOverHelpMenuItem()
                        .clickOnTos();
                break;
            case PRIVACY:
                page.moveMouseOverHelpMenuItem()
                        .clickOnPrivacy();
                break;
            case DMCA:
                page.moveMouseOverHelpMenuItem()
                        .clickOnDmca();
                break;
        }
    }

    private void goToLink(String pageName, HeaderLinksList link) {
        ServicePageLogged page = on(ServicePageLogged.class, pageName);
        switch (link) {
            case LOGO:
                page.clickOnLogo();
                break;
            case LJMAGAZINE:
                page.clickOnLjMagazineMenuItem();
                break;
            case FEED:
                page.moveMouseOverFriendsFeedMenuItem()
                        .clickOnFriendsFeed();
                break;
            case FRIENDSGROUP:
                page.moveMouseOverFriendsFeedMenuItem()
                        .clickOnMngGroups();
                break;
            case MNGGROUP:
                page.moveMouseOverFriendsFeedMenuItem()
                        .clickOnMngFriends();
                break;
            case MNGCOMMUNITIES:
                page.moveMouseOverFriendsFeedMenuItem()
                        .clickOnMngCommunities();
                break;
            case BANNEDUSERS:
                page.moveMouseOverFriendsFeedMenuItem()
                        .clickOnBannedUsers();
                break;
            case SHOP:
                page.moveMouseOverShopMenuItem()
                        .clickOnShop();
                break;
            case PAID:
                page.moveMouseOverShopMenuItem()
                        .clickOnPaid();
                break;

        }
    }
}
