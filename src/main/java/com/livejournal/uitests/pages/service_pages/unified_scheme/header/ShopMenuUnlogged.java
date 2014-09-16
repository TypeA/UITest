package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".s-nav-item-shop"))
public class ShopMenuUnlogged extends UIBlock {

    @FindBy(css = ".s-nav-item-mobile.s-nav-rootlink-shop")
    private Link shop;

    @FindBy(css = ".s-nav-item-paid-account")
    private Link paid;

    @FindBy(css = ".s-nav-item-promo")
    private Link promo;

    @FindBy(css = ".s-nav-item-tokens a")
    private Link tokens;

    @StepGroup
    public LoginPageUnlogged clickOnTokensLink() {
        tokens.click();
        return on(LoginPageUnlogged.class);
    }

}
