package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
public class ShopLogged extends ShopMenuItem
{
    @FindBy(css=".s-nav-item-paid-history")
    public Link orderHistory;
}
