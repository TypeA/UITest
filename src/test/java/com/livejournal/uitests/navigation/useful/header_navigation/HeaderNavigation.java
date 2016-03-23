package com.livejournal.uitests.navigation.useful.header_navigation;

import com.livejournal.uisteps.thucydides.elements.Page;
import com.livejournal.uitests.LJTest;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import java.util.ArrayList;
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
        open(MainPageLogged.class);
    }

    //Scenario: Navigation for unlogged user (1/3)   
    @Given("unlogged user from region $region on Main Page")
    public void unlogged_user_from_region_on_Main_Page(String region) {
        open(MainPageUnlogged.class)
                .regionSwitchUnlogged(region)
                .defaultLanguageUnlogged();
    }

    //Scenario: Navigation for logged user (2/3)
    @When("user goes from page using link $link")
    public void user_goes_from_page_using_link(String page, String link) {
        goToLinkLoggedService( HeaderLinksList.valueOf(link));
    }

    //Scenario: Navigation for unlogged user (2/3)
    @When("unlogged user goes from page using link $link")
    public void unlogged_user_goes_from_page_using_link(String page, String link) {
        goToLinkUnloggedService(HeaderLinksList.valueOf(link));
    }

    /*@When("user goes from journal page with syle $syle using link $link")
    public void user_goes_from_gournal_page(String style, String link) {

    }

    @When("user goes from journal page with syle $syle using link $link")
    public void unlogged_user_goes_from_gournal_page(String style, String link) {

    }*/
    //Scenario: Navigation for logged user (3/3)
    //Scenario: Navigation for unlogged user (3/3)
    @Then("user on correct page $correct_page")
    public void user_in_correct_Page(String correct_page) {
        verify().thatIsOn((Class<? extends Page>) this.getPageClassByName(correct_page))
                .finish();
    }

    private void goToLinkUnloggedService(HeaderLinksList link) {
        switch (link) {
            case LOGO:
                onOpened(MainPageUnlogged.class).clickOnLogo();
                break;
            case LJMAGAZINE:
                onOpened(MainPageUnlogged.class).clickOnLjMagazineMenuItem();
                break;
            case BROWSE:
                onOpened(MainPageUnlogged.class).moveMouseOverInterestingMenuItem()
                        .clickOnBrowse();
                break;
            case RSS:
                onOpened(MainPageUnlogged.class).moveMouseOverInterestingMenuItem()
                        .clickOnRss();
                break;
            case SHOP:
                onOpened(MainPageUnlogged.class).clickOnShopMenuItem();
                break;
            case HELP:
                onOpened(MainPageUnlogged.class).clickOnHelpMenuItem();
                break;
            case REGISTRATION:
                onOpened(MainPageUnlogged.class).clicOnSignUpMenuItem();
                break;
        }
    }

    private void goToLinkLoggedService(HeaderLinksList link) {
        switch (link) {
            case LOGO:
                onOpened(MainPageLogged.class).clickOnLogo();
                break;
            case LJMAGAZINE:
                onOpened(MainPageLogged.class).clickOnLjMagazineMenuItem();
                break;
            case BROWSE:
                onOpened(MainPageLogged.class).moveMouseOverInterestingMenuItem()
                        .clickOnBrowse();
                break;
            case RSS:
                onOpened(MainPageLogged.class).moveMouseOverInterestingMenuItem()
                        .clickOnRss();
                break;
            case FEED:
                onOpened(MainPageLogged.class).clickOnFriendsFeedMenuItem();
                break;
            case SHOP:
                onOpened(MainPageLogged.class).clickOnShopMenuItem();
                break;
            case NEWENTRY:
                onOpened(MainPageLogged.class).clickOnPostNewEntry();
                break;
            case JOURNAL:
                onOpened(MainPageLogged.class).clickOnMyJournalMenuItem();
                break;
            case PROFILE:
                onOpened(MainPageLogged.class).moveMouseOverMyJournalMenuItem()
                        .clickOnProfile();
                break;
            case STATISTICS:
                onOpened(MainPageLogged.class).moveMouseOverUserPicMenuItem()
                        .clickOnStatistics();
                break;
            case ALBUM:
                onOpened(MainPageLogged.class).moveMouseOverMyJournalMenuItem()
                        .clickOnScrapbook();
                break;
            case VIDEO:
                onOpened(MainPageLogged.class).moveMouseOverUserPicMenuItem()
                        .clickOnVideo();
                break;
            case MESSAGES:
                onOpened(MainPageLogged.class).moveMouseOverMyJournalMenuItem()
                        .clickOnMessagesInMenu();
                break;
            case SHEDULED:
                onOpened(MainPageLogged.class).moveMouseOverMyJournalMenuItem()
                        .clickOnSheduledEntries();
                break;
            case RECENTCOMMENTS:
                onOpened(MainPageLogged.class).moveMouseOverMyJournalMenuItem()
                        .clickOnRecentComments();
                break;
            case MNGCOMMUNITIES:
                onOpened(MainPageLogged.class).moveMouseOverMyJournalMenuItem()
                        .clickOnManageCommunities();
                break;
            case SETTINGS:
                onOpened(MainPageLogged.class).moveMouseOverUserPicMenuItem()
                        .clickOnSettings();
                break;
            case HELP:
                onOpened(MainPageLogged.class).moveMouseOverUserPicMenuItem()
                        .clickOnSupport();
                break;
            case LOGOUT:
                onOpened(MainPageLogged.class).moveMouseOverMyJournalMenuItem()
                        .clickOnLogOut();
                break;
        }
    }

    private String getRandomUserWithStyle(String style) {
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
        }
        return "No such user";
    }
}
