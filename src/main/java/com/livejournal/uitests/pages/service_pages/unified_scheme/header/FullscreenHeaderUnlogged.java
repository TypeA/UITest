package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageUnlogged;
import com.livejournal.uitests.pages.service_pages.main_pages.MainPageUnlogged;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.MenuBlocks.LangSwitch;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.MenuBlocks.ShopMenuUnlogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = HeaderLocator.CSS))
public class FullscreenHeaderUnlogged extends FullscreenHeader {

    @FindBy(css = ".s-nav-item.s-nav-item-login")
    private Link loginMenuItem;

    @FindBy(css = ".s-nav-item-lang-open")
    private LangSwitch langSwitch;

    @StepGroup
    public MainPageUnlogged clickOnLogo() {
        logo.click();
        return on(MainPageUnlogged.class);
    }

    @StepGroup
    public LJMagazinePageUnlogged clickOnLjMagazineMenuItem() {
        ljMagazineMenuItem.click();
        return on(LJMagazinePageUnlogged.class);
    }

    @StepGroup
    public LoginForm clickOnLoginMenuItem() {
        loginMenuItem.click();
        return on(LoginForm.class);
    }

    @StepGroup
    public ShopMenuUnlogged moveMouseOverShopMenuItem() {
        shopMenuItem.moveMouseOver();
        return on(ShopMenuUnlogged.class);
    }

    @StepGroup
    public LangSwitch moveMouseOverLangSwitch() {
        langSwitch.moveMouseOver();
        return on(LangSwitch.class);
    }
}
