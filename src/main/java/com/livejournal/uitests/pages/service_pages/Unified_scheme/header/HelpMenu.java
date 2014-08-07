/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
class HelpMenu extends UIBlock {

    @FindBy(css = ".s-nav-item-mobile.s-nav-rootlink-support")
    public Link help;

    @FindBy(css = ".s-nav-item-about")
    public Link about;

    @FindBy(css = ".s-nav-item-faq")
    public Link faq;

    @FindBy(css = ".s-nav-item-legal")
    public Link tos;

    @FindBy(css = ".s-nav-item-privacy")
    public Link privacy;

    @FindBy(css = ".s-nav-item-dmca")
    public Link dmca;

    @FindBy(css = ".s-nav-item-search #SearchText")
    public TextField searchLine;

}
