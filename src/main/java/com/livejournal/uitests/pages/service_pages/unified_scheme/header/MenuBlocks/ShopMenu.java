/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.unified_scheme.header.MenuBlocks;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */@Block(
        @FindBy(css = ShopMenu.CSS))
public class ShopMenu extends UIBlock {

    final static String CSS = ".s-nav-item-shop .s-drop";

    @FindBy(css = ".s-nav-item-mobile.s-nav-rootlink-shop")
    protected Link shop;

    @FindBy(css = ".s-nav-item-paid-account")
    protected Link paid;

    @FindBy(css = ".s-nav-item-promo")
    protected Link promo;

    @FindBy(css = ".s-nav-item-tokens a")
    protected Link tokens;
}
