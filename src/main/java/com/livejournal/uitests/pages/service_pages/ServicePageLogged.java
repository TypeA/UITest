package com.livejournal.uitests.pages.service_pages;

import com.livejournal.uitests.pages.service_pages.error_strip.ErrorStrip;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeaderLogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.FriendsFeedMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.MyJournalMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.helpMenu.HelpMenuLogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.shopMenu.ShopMenuLogged;
import net.thucydides.core.annotations.StepGroup;

/**
 *
 * @author m.prytkova
 */
public class ServicePageLogged extends ServicePage {

    private FullscreenHeaderLogged fullscreenHeaderLogged;

    private ErrorStrip errorStrip;

    @Override
    public FullscreenHeaderLogged getFullscreenHeader() {
        return fullscreenHeaderLogged;
    }

    @Override
    public ErrorStrip getErrorStrip() {
        return errorStrip;
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

}
