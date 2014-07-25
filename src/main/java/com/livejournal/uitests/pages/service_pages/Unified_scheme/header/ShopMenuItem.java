/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".s-nav-rootlink.s-nav-rootlink-shop"))
public class ShopMenuItem extends UIBlock {

    @FindBy(css = ".s-nav-item-mobile.s-nav-rootlink-shop")
    private Link shop;

    @FindBy(css = ".s-nav-item-paid-account")
    private Link paid;

    @FindBy(css = ".s-nav-item-promo")
    private Link promo;

    @FindBy(css = ".s-nav-item-tokens")
    private Link tokens;

    public Link getShop() {
        return elem(shop);
    }

    public Link getPaid() {
        return elem(paid);
    }

    public Link getPromo() {
        return elem(promo);
    }

    public Link getTokens() {
        return elem(tokens);
    }

}
