package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.common_elements.LoginForm;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import com.livejournal.uitests.pages.service_pages.lj_magazine_page.LJMagazinePageUnlogged;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = HeaderLocator.CSS))
public class FullscreenHeaderUnlogged extends FullscreenHeader {

    @FindBy(css = ".s-nav-item.s-nav-item-login a")
    private Link loginMenuItem;

    @FindBy(css=".s-nav-item-lang-open")
    private LangSwitch langSwitch;

    public ServicePageUnlogged clickOnLogo() {
        logo.click();
        return on(ServicePageUnlogged.class);
    }

    public LJMagazinePageUnlogged clickOnLjMagazineMenuItem() {
        ljMagazineMenuItem.click();
        return on(LJMagazinePageUnlogged.class);
    }

    public LoginForm clickOnLoginMenuItem() {
        loginMenuItem.click();
        return on(LoginForm.class);
    }

    public ShopMenuUnlogged moveMouseOverShopMenuItem() {
        shopMenuItem.moveMouseOver();
        return on(ShopMenuUnlogged.class);
    }
    
    public LangSwitch moveMouseOverLangSwitch() {
        langSwitch.moveMouseOver();
        return on(LangSwitch.class);
    }
}
