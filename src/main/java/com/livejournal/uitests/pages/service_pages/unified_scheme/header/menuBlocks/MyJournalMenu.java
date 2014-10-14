package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import com.livejournal.uitests.pages.service_pages.inbox_pages.InboxMainPage;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePage;
import com.livejournal.uitests.pages.service_pages.scrapbook.ScrapBookMainPage;
import com.livejournal.uitests.pages.service_pages.settings.CustomizeJournalPage;
import com.livejournal.uitests.pages.service_pages.settings.EditPicsPage;
import com.livejournal.uitests.pages.service_pages.settings.EditProfilePage;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
import com.livejournal.uitests.pages.service_pages.settings.TagsPage;
import com.livejournal.uitests.pages.service_pages.tools.MemoriesPage;
import com.livejournal.uitests.pages.service_pages.tools.RecentCommentsPage;
import com.livejournal.uitests.pages.service_pages.tools.StatisticsMainPage;
import com.livejournal.uitests.pages.service_pages.update.SheduledEntriesPage;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".s-nav-item-user .s-drop"))
public class MyJournalMenu extends UIBlock {

    @FindBy(css = ".s-nav-item-you a")
    public Link authorizedAs;

    @FindBy(css = ".s-nav-item-post a")
    public Link newPost;

    @FindBy(css = ".s-nav-item-profile a")
    public Link profile;

    @FindBy(css = ".s-nav-item-prodile-edit a")
    public Link editProfile;

    @FindBy(css = ".s-nav-item-edit-pics a")
    public Link editPics;

    @FindBy(css = ".s-nav-item-counter a")
    public Link messagesInMenu;

    @FindBy(css = ".s-nav-item-scheduled a")
    public Link sheduledEntries;

    @FindBy(css = ".s-nav-item-comments a")
    public Link recentComments;

    @FindBy(css = ".s-nav-item-statistics a")
    public Link statistics;

    @FindBy(css = ".s-nav-item-scrapbook a")
    public Link scrapbook;

    @FindBy(css = ".s-nav-item-tags a")
    public Link tags;

    @FindBy(css = ".s-nav-item-memories a")
    public Link memories;

    @FindBy(css = ".s-nav-item-customize a")
    public Link journalStyle;

    @FindBy(css = ".s-nav-item-settings a")
    public Link settings;

    @FindBy(css = ".s-nav-item-logout a")
    public Link logOut;

    @StepGroup
    public void clickOnAuthotizedAs() {
        authorizedAs.click();
       /* String pageSource = getDriver().getPageSource();
        Pattern pattern = Pattern.compile("lj:user=\"(.*)\" >.*");
        Matcher matcher = pattern.matcher(pageSource);
        String name = "";     
        if (matcher.find()) {
            name = matcher.group(0);
        }
        *///return on(MyJournalPage.class);//, new Url().setPrefix(name + "."));
    }

    @StepGroup
    public void clickOnNewPost() {
        newPost.click();
        //return on(UpdateBmlPageLogged.class);
    }

    @StepGroup
    public void clickOnProfile() {
        profile.click();
       // return on(ProfilePage.class);//, new Url().setPrefix(name + "."));
    }

    @StepGroup
    public void clickOnEditProfie() {
        editProfile.click();
        //return on(EditProfilePage.class);
    }

    @StepGroup
    public void clickOnEditPics() {
        editPics.click();
        //return on(EditPicsPage.class);
    }

    @StepGroup
    public void clickOnMessagesInMenu() {
        messagesInMenu.click();
        //return on(InboxMainPage.class);
    }

    @StepGroup
    public void clickOnSheduledEntries() {
        sheduledEntries.click();
        //return on(SheduledEntriesPage.class);
    }

    @StepGroup
    public void clickOnRecentComments() {
        recentComments.click();
        //return on(RecentCommentsPage.class);
    }

    @StepGroup
    public void clickOnStatistics() {
        statistics.click();
        //return on(StatisticsMainPage.class);
    }

    @StepGroup
    public void clickOnScrapbook() {
        scrapbook.click();
       // return on(ScrapBookMainPage.class);//, new Url().setPrefix(name + "."));
    }

    @StepGroup
    public void clickOnTags() {
        tags.click();
        //return on(TagsPage.class);
    }

    @StepGroup
    public void clickOnMemories() {
        memories.click();
        //return on(MemoriesPage.class);
    }

    @StepGroup
    public void clickOnJournalStyle() {
        journalStyle.click();
        //return on(CustomizeJournalPage.class);
    }

    @StepGroup
    public void clickOnSettings() {
        settings.click();
        //return on(SettingsMainPage.class);
    }

    @StepGroup
    public void clickOnLogOut() {
        logOut.click();
        //return on(ServicePageUnlogged.class);
    }
}
