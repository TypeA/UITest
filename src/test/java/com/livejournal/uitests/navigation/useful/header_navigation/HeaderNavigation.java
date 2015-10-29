package com.livejournal.uitests.navigation.useful.header_navigation;

import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 *
 * @author m.prytkova
 */
public class HeaderNavigation extends LJTest {

    //Scenario: Navigation for logged user (1/3)
    @Given("logged user (name $name,region $region) on Main Page")
    public void logged_user_on_Main_Page(String name, String region) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .defaultLanguageLogged(name)
                .regionSwitchLogged(name, region);
    }

    //Scenario: Navigation for unlogged user (1/3)   
    @Given("unlogged user from region $region on Main Page")
    public void unlogged_user_from_region_on_Main_Page(String region) {
        open(MainPageUnlogged.class)
                .regionSwitchUnlogged(region)
                .defaultLanguageUnlogged();
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
            case BROWSE:
                page.moveMouseOverInterestingMenuItem()
                        .clickOnBrowse();
                break;
            case RSS:
                page.moveMouseOverInterestingMenuItem()
                        .clickOnRss();
                break;
            case SHOP:
                page.clickOnShopMenuItem();
                break;
            case HELP:
                page.clickOnHelpMenuItem();
                break;
            case REGISTRATION:
                page.clicOnSignUpMenuItem();
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
            case BROWSE:
                page.moveMouseOverInterestingMenuItem()
                        .clickOnBrowse();
                break;
            case RSS:
                page.moveMouseOverInterestingMenuItem()
                        .clickOnRss();
                break;
            case FEED:
                page.clickOnFriendsFeedMenuItem();
                break;
            case SHOP:
                page.clickOnShopMenuItem();
                break;
            case NEWENTRY:
                page.clickOnPostNewEntry();
                break;
            case JOURNAL:
                page.clickOnMyJournalMenuItem();
                break;
            case PROFILE:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnProfile();
                break;
            case STATISTICS:
                page.moveMouseOverUserPicMenuItem()
                        .clickOnStatistics();
                break;
            case ALBUM:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnScrapbook();
                break;
            case VIDEO:
                page.moveMouseOverUserPicMenuItem()
                        .clickOnVideo();
                break;
            case MESSAGES:
                page.moveMouseOverMyJournalMenuItem()
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
            case MNGCOMMUNITIES:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnManageCommunities();
                break;
            case SETTINGS:
                page.moveMouseOverUserPicMenuItem()
                        .clickOnSettings();
                break;
            case HELP:
                page.moveMouseOverUserPicMenuItem()
                        .clickOnSupport();
                break;
            case LOGOUT:
                page.moveMouseOverMyJournalMenuItem()
                        .clickOnLogOut();
                break;


        }
    }

}
