package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.journal_pages.MyJournalPage;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageLogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.logged.ShopPageLogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.MyJournalMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.findMoreMenu.FindMoreMenuLogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = FullscreenHeader.CSS))
public class FullscreenHeaderLogged extends FullscreenHeader {

    @FindBy(css = ".s-header-item__link--friends")
    public Link friendsFeedMenuItem;

    @FindBy(css = ".s-userpic")
    public Link userPicMenuItem;

    @FindBy(css = ".s-nav-item__name")
    public Link myJournalMenuItem;

    @FindBy(css = ".s-header-item__link--post")
    public Link postNewEntry;

    @StepGroup
    public MainPageLogged clickOnLogo() {
        logo.click();
        return onOpened(MainPageLogged.class);
    }

    @StepGroup
    public LJMagazinePageLogged clickOnLjMagazineMenuItem() {
        ljMagazineMenuItem.click();
        return onOpened(LJMagazinePageLogged.class);
    }

    @StepGroup
    public FindMoreMenuLogged moveMouseOverInterestingMenuItem() {
        interestingMenuItem.moveMouseOver();
        return onDisplayed(FindMoreMenuLogged.class);
    }

    @StepGroup
    public FriendsFeedLogged clickOnFriendsFeedMenuItem() {
        friendsFeedMenuItem.click();
        return onOpened(FriendsFeedLogged.class);
    }

    @StepGroup
    public ShopPageLogged clickOnShopMenuItem() {
        shopMenuItem.click();
        return onOpened(ShopPageLogged.class);
    }

    @StepGroup
    public UpdateBmlPageLogged clickOnPostNewEntry() {
        postNewEntry.click();
        return onOpened(UpdateBmlPageLogged.class);
    }

    @StepGroup
    public MyJournalPage clickOnMyJournalMenuItem() {
        myJournalMenuItem.click();
        return onOpened(MyJournalPage.class);
    }

    @StepGroup
    public MyJournalMenu moveMouseOverUserPicMenuIem() {
        userPicMenuItem.moveMouseOver();
        return onDisplayed(MyJournalMenu.class);
    }

    @StepGroup
    public MyJournalMenu moveMouseOverMyJournalMenuItem() {
        myJournalMenuItem.moveMouseOver();
        return onDisplayed(MyJournalMenu.class);
    }

}
