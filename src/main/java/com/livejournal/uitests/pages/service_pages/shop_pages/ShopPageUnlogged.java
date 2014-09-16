package com.livejournal.uitests.pages.service_pages.shop_pages;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import com.livejournal.uitests.pages.service_pages.login_page.LoginPageUnlogged;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/shop")
public class ShopPageUnlogged extends ServicePageUnlogged {

    @FindBy(css = ".m-section-list a[href*='/tokens.bml']")
    private Link tokensLink;

    // допиши все имеющиеся ссылки
    
    @FindBy(css = ".m-section-list a[href*='/renameaccount.bml']")
    private Link renameAccountLink;

    public LoginPageUnlogged clickOnTokensLink() {
        tokensLink.click();
        return on(LoginPageUnlogged.class);
    }

    public LoginPageUnlogged clickOnRenameAccountLink() {
        renameAccountLink.click();
        return on(LoginPageUnlogged.class);
    }
}
