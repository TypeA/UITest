package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.shopMenu;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ShopMenu.CSS))
public class ShopMenu extends UIBlock {

    final static String CSS = ".s-nav-item-shop .s-drop";

    @FindBy(css = ".s-nav-item-mobile.s-nav-rootlink-shop a")
    protected Link shop;

    @FindBy(css = ".s-nav-item-paid-account a")
    protected Link paid;

    @FindBy(css = ".s-nav-item-promo a")
    protected Link promo;

    @FindBy(css = ".s-nav-item-tokens a")
    protected Link tokens;
}
