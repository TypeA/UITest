package com.livejournal.uitests.pages.journal_pages;

import com.livejournal.uitests.pages.journal_pages.journal.MyJournalPageLogged;
import com.livejournal.uitests.pages.service_pages.error_strip.ErrorStrip;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageLogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.logged.ShopPageLogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeaderLogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.MyJournalMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.findMoreMenu.FindMoreMenuLogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import net.thucydides.core.annotations.StepGroup;

/**
 *
 * @author s.savinykh
 */
public class JournalPageLogged extends JournalPage {

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
    public LJMagazinePageLogged clickOnLjMagazineMenuItem() {
        return getFullscreenHeader().clickOnLjMagazineMenuItem();
    }

    public FindMoreMenuLogged moveMouseOverInterestingMenuItem() {
        return getFullscreenHeader().moveMouseOverInterestingMenuItem();
    }

    @StepGroup
    public FriendsFeedLogged clickOnFriendsFeedMenuItem() {
        return getFullscreenHeader().clickOnFriendsFeedMenuItem();
    }

    @StepGroup
    public ShopPageLogged clickOnShopMenuItem() {
        return getFullscreenHeader().clickOnShopMenuItem();
    }

    @StepGroup
    public MyJournalPageLogged clickOnMyJournalMenuItem() {
        return getFullscreenHeader().clickOnMyJournalMenuItem();
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
    public UpdateBmlPageLogged clickOnPostNewEntry() {
        return getFullscreenHeader().clickOnPostNewEntry();
    }

}
