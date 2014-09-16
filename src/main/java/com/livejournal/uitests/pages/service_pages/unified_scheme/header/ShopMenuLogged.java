package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
public class ShopMenuLogged extends ShopMenuUnlogged {

    @FindBy(css = ".s-nav-item-paid-history")
    public Link orderHistory;

}
