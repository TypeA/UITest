package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import net.thucydides.core.annotations.findby.FindBy;

/**
 *
 * @author s.savinykh
 */
public class FullscreenHeaderUnlogged extends FullscreenHeader {

    private ShopMenuItem shopMenuItem;

    @FindBy(css = ".s-nav-item.s-nav-item-login a")
    private Link loginMenuItem;

    private LangSwitch langSwitch;

    public ShopMenuItem getShopMenuItem() {
        return elem(shopMenuItem);
    }

    public Link getLoginMenuItem() {
        return elem(loginMenuItem);
    }

    public LangSwitch getLangSwitch() {
        return elem(langSwitch);
    }

}
