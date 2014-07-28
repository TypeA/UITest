package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css=HeaderLocator.CSS))
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
