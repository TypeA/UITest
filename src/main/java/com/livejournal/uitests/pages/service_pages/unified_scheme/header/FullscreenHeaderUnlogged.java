package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.browse.BrowseMainPageUnlogged;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.search.SearchPageUnlogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.LangSwitchMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.helpMenu.HelpMenuUnlogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.shopMenu.ShopMenuUnlogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = FullscreenHeader.CSS))
public class FullscreenHeaderUnlogged extends FullscreenHeader {

    @FindBy(css = ".s-nav-item.s-nav-item-login")
    private Link loginMenuItem;

    @FindBy(css = ".s-nav-item-lang-open")
    private Link langSwitch;

    @FindBy(css = ".s-inline-search-input")
    public TextField searchMenuItem;

    @StepGroup
    public MainPageUnlogged clickOnLogo() {
        logo.click();
        return onOpened(MainPageUnlogged.class);
    }

    @StepGroup
    public LJMagazinePageUnlogged clickOnLjMagazineMenuItem() {
        ljMagazineMenuItem.click();
        return onOpened(LJMagazinePageUnlogged.class);
    }

    public BrowseMainPageUnlogged clickOnbrowseMenuItem() {
        browseMenuItem.click();
        return onOpened(BrowseMainPageUnlogged.class);
    }

    @StepGroup
    public LoginForm clickOnLoginMenuItem() {
        loginMenuItem.click();
        return onDisplayed(LoginForm.class);
    }

    @StepGroup
    public ShopMenuUnlogged moveMouseOverShopMenuItem() {
        shopMenuItem.moveMouseOver();
        return onDisplayed(ShopMenuUnlogged.class);
    }

    @StepGroup
    public HelpMenuUnlogged moveMouseOverHelpMenuItem() {
        helpMenuItem.moveMouseOver();
        return onDisplayed(HelpMenuUnlogged.class);
    }

    @StepGroup
    public LangSwitchMenu moveMouseOverLangSwitch() {
        langSwitch.moveMouseOver();
        return onDisplayed(LangSwitchMenu.class);
    }

    @StepGroup
    public SearchPageUnlogged useSearchLogged(String text) {
        searchMenuItem.enter(text);
        sendKeys(Keys.ENTER);
        return onOpened(SearchPageUnlogged.class);
    }
}
