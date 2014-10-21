package com.livejournal.uitests.navigation.useful.header_navigation;

import com.livejournal.uisteps.thucydides.WebTest;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
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
        open(LoginPageUnlogged.class);
        getCurrentBrowser().getDriver().manage().addCookie(new Cookie("fake_ipclass", "russia"));
        open(LoginPageUnlogged.class)
                .authorizeBy(name, password);
    }

    //Scenario: Navigation for unlogged user (1/3)   
    @Given("unlogged user on Main Page")
    public void unlogged_user_on_Main_Page() {
        open(LoginPageUnlogged.class);
        this.getCurrentBrowser().getDriver().manage().addCookie(new Cookie("fake_ipclass", "russia"));
        this.getCurrentBrowser().getDriver().manage().addCookie(new Cookie("prop_friendsfeed_tour", "%7B%22regionalrating%22%3A0%7D"));
        open(MainPageUnlogged.class);
    }

    //Scenario: Navigation for logged user (2/3)
    @When("user goes from page $page using link $link")
    public void user_goes_from_page_using_link(String page, String link) {
        goToLinkLogged(page, HeaderLinksList.valueOf(link));
    }

    //Scenario: Navigation for unlogged user (2/3)
    @When("unlogged user goes from page $page using link $link")
    public void unlogged_user_goes_from_page_using_link(String page, String link) {
        goToLinkUnlogged(page, HeaderLinksList.valueOf(link));
    }


    //Scenario: Navigation for logged user (3/3)
    //Scenario: Navigation for unlogged user (3/3)
    @Then("user on correct page $correct_page")
    public void user_in_correct_Page(String correct_page) {
        verify().thatIsOn((Class<? extends Page>) this.getPageClassByName(correct_page))
                .finish();
    }

    private void goToLinkUnlogged(String pageName, HeaderLinksList link) {
        ServicePageUnlogged page = open((Class<ServicePageUnlogged>) this.getPageClassByName(pageName));
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

    private void goToLinkLogged(String pageName, HeaderLinksList link) {
        ServicePageLogged page = open((Class<ServicePageLogged>) this.getPageClassByName(pageName));
        switch (link) {
            case LOGO:
                page.clickOnLogo();
                break;
            case LJMAGAZINE:
                page.clickOnLjMagazineMenuItem();
                break;
            case MNGGROUP:
                page.moveMouseOverFriendsFeedMenuItem()
                        .clickOnMngGroups();
                break;
            case MNGFRIENDS:
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
            case PROMO:
                page.moveMouseOverShopMenuItem()
                        .clickOnPromo();
                break;
            case HISTORY:
                page.moveMouseOverShopMenuItem()
                        .clickOnOrderHistory();
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
            case NEWENTRYINMENU:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnNewPost();
                break;
            case EDITPROFILE:
                page.moveMouseOverUserPicMenuItem()
                        .clickOnEditProfie();
                break;
            case MANAGEUSERPICS:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnEditPics();
                break;
            case MESSAGESINMENU:
                page.moveMouseOverUserPicMenuItem()
                        .clickOnMessagesInMenu();
                break;
            case SHEDULED:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnSheduledEntries();
                break;
            case RECENTCOMMENTS:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnRecentComments();
                break;
            case STATISTICS:
                page.moveMouseOverUserPicMenuItem()
                        .clickOnStatistics();
                break;
            case TAGS:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnTags();
                break;
            case MEMORIES:
                page.moveMouseOverUserPicMenuItem()
                        .clickOnMemories();
                break;
            case JOURNALSTYLE:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnJournalStyle();
                break;
            case SETTINGS:
                page.moveMouseOverUserPicMenuItem()
                        .clickOnSettings();
                break;
            case LOGOUT:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnLogOut();
                break;
            case JOURNAL:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnAuthotizedAs();
                break;
            case PROFILE:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnProfile();
                break;
            case ALBUM:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnScrapbook();
                break;
            case FEED:
                page.moveMouseOverFriendsFeedMenuItem()
                        .clickOnFriendsFeed();
                break;

        }
    }

}
