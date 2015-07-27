package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.create_account_pages.CreateAccountPage;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.shop_pages.unlogged.ShopPageUnlogged;
import com.livejournal.uitests.pages.service_pages.support_faq.unlogged.SupportMainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.LangSwitchMenu;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.findMoreMenu.FindMoreMenuUnlogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = FullscreenHeader.CSS))
public class FullscreenHeaderUnlogged extends FullscreenHeader {

    @FindBy(css = ".s-header-item__link--login")
    private Link loginMenuItem;
  
    @FindBy(css = ".s-nav-item-lang")
    private Link langSwitch;

    @FindBy(css = ".s-header-item--signup a")
    private Link signupMenuItem;

    @FindBy(css = ".s-header-item__link--support")
    private Link helpMenuItem;
    
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

    @StepGroup
    public FindMoreMenuUnlogged moveMouseOverInterestingMenuItem() {
        interestingMenuItem.moveMouseOver();
        return onDisplayed(FindMoreMenuUnlogged.class);
    }

    @StepGroup
    public LoginForm clickOnLoginMenuItem() {
        loginMenuItem.click();
        return onDisplayed(LoginForm.class);
    }

    @StepGroup
    public ShopPageUnlogged clickOnShopMenuItem() {
        shopMenuItem.click();
        return onOpened(ShopPageUnlogged.class);
    }

    @StepGroup
    public SupportMainPageUnlogged clickOnHelpMenuItem() {
        helpMenuItem.click();
        return onOpened(SupportMainPageUnlogged.class);
    }

    @StepGroup
    public LangSwitchMenu moveMouseOverLangSwitch() {
        langSwitch.moveMouseOver();
        return onDisplayed(LangSwitchMenu.class);
    }
    
    @StepGroup
    public CreateAccountPage clicOnSignUpMenuItem() {
        signupMenuItem.click();
        return onOpened(CreateAccountPage.class);
    }
    
    /*@StepGroup
    public SearchPageUnlogged useSearchLogged(String text) {
        searchMenuItem.enter(text);
        sendKeys(Keys.ENTER);
        return onOpened(SearchPageUnlogged.class);
    }*/
}
