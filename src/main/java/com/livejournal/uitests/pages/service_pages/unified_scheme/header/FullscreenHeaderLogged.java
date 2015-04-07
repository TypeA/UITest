package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.browse.BrowseMainPageLogged;
import com.livejournal.uitests.pages.service_pages.friends_feed_pages.FriendsFeedLogged;
import com.livejournal.uitests.pages.service_pages.inbox_pages.InboxMainPage;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageLogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageLogged;
import com.livejournal.uitests.pages.service_pages.search.SearchPageLogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.FriendsFeedMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.MyJournalMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.helpMenu.HelpMenuLogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.shopMenu.ShopMenuLogged;
import com.livejournal.uitests.pages.service_pages.update.UpdateBmlPageLogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = FullscreenHeader.CSS))
public class FullscreenHeaderLogged extends FullscreenHeader {

    @FindBy(css = ".s-nav-item-friends")
    public Link friendsFeedMenuItem;

    @FindBy(css = ".s-nav-item-user div.s-userpic")
    public Link userPicMenuItem;

    @FindBy(css = ".s-nav-rootlink-blog")
    public Link myJournalMenuItem;

    @FindBy(css = ".s-inline-search-input")
    public TextField searchMenuItem;

    @FindBy(css = ".s-do-item.s-do-item-post")
    public Link postNewEntry;

    @FindBy(css = ".s-do-item.s-do-item-message")
    public Link messagesMenuItem;

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
    public BrowseMainPageLogged clickOnbrowseMenuItem() {
        browseMenuItem.click();
        return onOpened(BrowseMainPageLogged.class);
    }

    @StepGroup
    public FriendsFeedMenu moveMouseOverFriendsFeedMenuItem() {
        friendsFeedMenuItem.moveMouseOver();
        return onDisplayed(FriendsFeedMenu.class);
    }

    @StepGroup
    public ShopMenuLogged moveMouseOverShopMenuItem() {
        shopMenuItem.moveMouseOver();
        return onDisplayed(ShopMenuLogged.class);
    }

    @StepGroup
    public HelpMenuLogged moveMouseOverHelpMenuItem() {
        helpMenuItem.moveMouseOver();
        return onDisplayed(HelpMenuLogged.class);
    }

    @StepGroup
    public UpdateBmlPageLogged clickOnPostNewEntry() {
        postNewEntry.click();
        return onOpened(UpdateBmlPageLogged.class);
    }

    @StepGroup
    public InboxMainPage clickOnMessagesMenuItem() {
        messagesMenuItem.click();
        return onOpened(InboxMainPage.class);
    }

    @StepGroup
    public SearchPageLogged useSearchLogged(String text) {
        searchMenuItem.enter(text);
        sendKeys(Keys.ENTER);
        return onOpened(SearchPageLogged.class);
    }

}
