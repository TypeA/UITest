package com.livejournal.uitests.adaptive_and_navigation.navigation.useful.header_navigation;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.journal_pages.JournalPageLogged;
import com.livejournal.uitests.pages.journal_pages.JournalPageUnlogged;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.SupportMainPageUnlogged;
import java.util.ArrayList;
import net.thucydides.core.annotations.StepGroup;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 *
 * @author m.prytkova
 */
public class HeaderNavigation extends LJTest {

    //Scenario: Navigation for logged user (1/3)
    //Scenario: Navigation for logged user on journal pages(1/3)
    @Given("logged user (name $name,region $region) on Main Page")
    public void logged_user_on_Main_Page(String name, String region) {
        open(LoginPageUnlogged.class)
                .authorizeBy(name, getDBDate().userData().getUserPassword(name))
                .setDefault().defaultLanguageLogged(name)
                .region().regionSwitchLogged(name, region);
    }

    //Scenario: Navigation for unlogged user (1/3)   
    //Scenario: Navigation for unlogged user on journal pages(1/3)
    @Given("unlogged user from region $region on Main Page")
    public void unlogged_user_from_region_on_Main_Page(String region) {
        open(SupportMainPageUnlogged.class)
                .region().regionSwitchUnlogged(region)
                .setDefault().defaultLanguageUnlogged();
    }

    //Scenario: Navigation for logged user (2/3)
    @When("user goes from page using link $link")
    public void user_goes_from_page_using_link(String page, String link) {
        goToLinkLoggedService(HeaderLinksList.valueOf(link));
    }

    //Scenario: Navigation for unlogged user (2/3)
    @When("unlogged user goes from page using link $link")
    public void unlogged_user_goes_from_page_using_link(String page, String link) {
        goToLinkUnloggedService(HeaderLinksList.valueOf(link));
    }

    //Scenario: Navigation for logged user on journal pages(2/3)
    @When("logged user on journal page with syle $syle use link $link")
    public void user_goes_from_gournal_page(String style, String link) {
        String randomUser = getRandomUserWithStyle(style);
        Assert.assertFalse("There is no required user", randomUser.isEmpty());
        open(JournalPageLogged.class, new Url().setPrefix(randomUser + "."));
        goToLinkLoggedJournal(HeaderLinksList.valueOf(link));
    }

    //Scenario: Navigation for unlogged user on journal pages(2/3)
    @When("unlogged user on journal page with syle $syle use link $link")
    public void unlogged_user_goes_from_gournal_page(String style, String link) {
        String randomUser = getRandomUserWithStyle(style);
        Assert.assertFalse("There is no required user", randomUser.isEmpty());
        open(JournalPageUnlogged.class, new Url().setPrefix(randomUser + "."));
        goToLinkUnloggedJournal(HeaderLinksList.valueOf(link));
    }

    //Scenario: Navigation for logged user (3/3)
    //Scenario: Navigation for unlogged user (3/3)
    //Scenario: Navigation for logged user on journal pages(3/3)
    //Scenario: Navigation for unlogged user on journal pages(3/3)
    @Then("user on correct page $correct_page")
    public void user_in_correct_Page(String correct_page) {
        verify().thatIsOn((Class<? extends Page>) this.getPageClassByName(correct_page))
                .finish();
    }

    @StepGroup
    public void goToLinkUnloggedService(HeaderLinksList link) {
        ServicePageUnlogged page = onOpened(SupportMainPageUnlogged.class);
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

    @StepGroup
    public void goToLinkLoggedService(HeaderLinksList link) {
        ServicePageLogged page = onOpened(ServicePageLogged.class);
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
    
    @StepGroup
    public void goToLinkUnloggedJournal(HeaderLinksList link) {
        JournalPageUnlogged page = onOpened(JournalPageUnlogged.class);
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

    @StepGroup
    public void goToLinkLoggedJournal(HeaderLinksList link) {
        JournalPageLogged page = onOpened(JournalPageLogged.class);
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

    @StepGroup
    public String getRandomUserWithStyle(String style) {
        String script = "SELECT DISTINCT user.user "
                + "FROM user "
                + "left join lj_c1.userproplite2 on user.userid = lj_c1.userproplite2.userid "
                + "left join s2styles on lj_c1.userproplite2.value = s2styles.styleid "
                + "left join lj_c1.log2 on lj_c1.log2.journalid = user.userid "
                + "WHERE  lj_c1.userproplite2.upropid = 96 "
                + "AND user.statusvis = 'V' "
                + "AND lj_c1.log2.security = 'public' "
                + "AND user.journaltype = 'P'";
        switch (style.toUpperCase()) {
            case "AIR":
                script += "AND s2styles.name like '%wizard-air/default_theme%';";
                break;
            case "CHAMELEON":
                script += "AND s2styles.name like '%chameleon%' "
                        + "AND s2styles.name !='wizard-chameleon/__none' "
                        + "AND s2styles.name NOT LIKE '%chameleonljart%' "
                        + "AND s2styles.name NOT LIKE '%chamljartv2%' "
                        + "AND s2styles.name !='wizard-chameleon/__headerin_alpha' "
                        + "AND s2styles.name !='wizard-chameleon/bright-decorations' "
                        + "AND s2styles.name !='wizard-chameleon/orange-tinsel';";
                break;
            case "EXPRESSIVE":
                script += "AND s2styles.name like '%wizard-voxhtml/%';";
                break;
            case "MINIMALISM":
                script += "AND s2styles.name like '%wizard-sup/%';";
                break;
            case "SMOOTH SAILING":
                script += "AND s2Styles.name like '%wizard-smoothsailing/%';";
                break;
            case "TRANQUILITY":
                script += "AND s2Styles.name like '%wizard-component/%';";
                break;
            case "BLOGGISH":
                script += "AND s2Styles.name like '%wizard-sixhtml/%';";
                break;
            case "FLEXIBLE SQUARES":
                script += "AND s2Styles.name like '%wizard-flexiblesquares/%';";
                break;
        }
        ArrayList<String> users = workWithDB().conect()
                .select(script, "user")
                .finish()
                .get(0);
        if (!users.isEmpty()) {
            users.remove("system");
            users.remove("user");
            int index = (int) (Math.random() * (users.size()));
            return users.get(index);
        } else {
            return "";
        }
    }
}
