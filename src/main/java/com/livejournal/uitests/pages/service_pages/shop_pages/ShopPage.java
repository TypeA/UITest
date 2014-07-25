package com.livejournal.uitests.pages.service_pages.shop_pages;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.service_pages.ServicePage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/shop")
public class ShopPage extends ServicePage {

    @FindBy(css = ".m-section-list a[href*='/tokens.bml']")
    private Link tokens;

    // допиши все имеющиеся ссылки
    
    @FindBy(css = ".m-section-list a[href*='/renameaccount.bml']")
    private Link renameAccount;

    public Link getTokens() {
        return elem(tokens);
    }

    public Link getRenameAccount() {
        return elem(renameAccount);
    }
}
