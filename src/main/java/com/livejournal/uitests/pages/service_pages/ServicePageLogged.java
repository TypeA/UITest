package com.livejournal.uitests.pages.service_pages;

import com.livejournal.uisteps.core.Url;
import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.inbox_pages.InboxMainPage;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageLogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeaderLogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.FriendsFeedMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.MyJournalMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.helpMenu.HelpMenuLogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.shopMenu.ShopMenuLogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import net.thucydides.core.annotations.StepGroup;

/**
 *
 * @author m.prytkova
 */
public class ServicePageLogged extends ServicePage {

    public FullscreenHeaderLogged fullscreenHeaderLogged;

    @Override
    public FullscreenHeaderLogged getFullscreenHeader() {
        return fullscreenHeaderLogged;
    }

    @StepGroup
    public MainPageLogged clickOnLogo() {
        return getFullscreenHeader().clickOnLogo();
    }

    @StepGroup
    public void clickOnLjMagazineMenuItem() {
        getFullscreenHeader().clickOnLjMagazineMenuItem();
    }

    public void clickOnbrowseMenuItem() {
        getFullscreenHeader().clickOnbrowseMenuItem();
    }

    @StepGroup
    public FriendsFeedMenu moveMouseOverFriendsFeedMenuItem() {
        return getFullscreenHeader().moveMouseOverFriendsFeedMenuItem();
    }

    @StepGroup
    public ShopMenuLogged moveMouseOverShopMenuItem() {
        return getFullscreenHeader().moveMouseOverShopMenuItem();
    }

    @StepGroup
    public HelpMenuLogged moveMouseOverHelpMenuItem() {
        return getFullscreenHeader().moveMouseOverHelpMenuItem();
    }

    @StepGroup
    public MyJournalMenu moveMouseOverMyJournalMenuItem() {
        return getFullscreenHeader().moveMouseOverMyJournalMenuItem();
    }

    @StepGroup
    public MyJournalMenu moveMouseOverUserPicMenuItem() {
        return getFullscreenHeader().moveMouseOverUserPicMenuIem();
    }

    @StepGroup
    public void clickOnPostNewEntry() {
        getFullscreenHeader().clickOnPostNewEntry();
    }

    @StepGroup
    public void clickOnMessagesMenuItem() {
        getFullscreenHeader().clickOnMessagesMenuItem();
    }

    @StepGroup
    public ServicePageLogged regionSwitch(String user, String region) {
        switch (region.toUpperCase()) {
            case "CYR":
                if (workWithDB().getCyrSetting(user).equals("NONCYR")) {
                    open(SettingsMainPage.class, new Url().setPostfix("?cat=display")).changeCyrServices().saveSettings();
                }
                break;
            case "NONCYR":
                if (workWithDB().getCyrSetting(user).equals("CYR")) {
                    open(SettingsMainPage.class, new Url().setPostfix("?cat=display")).changeCyrServices().saveSettings();
                }
                break;
        }
        return this;
    }
}
