/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.unified_scheme.footer;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
public class FooterFullscreen extends UIBlock {

    public SocialNetworks socialNetworks;

    public SwitchLangFooter switchLangFooter;

    @FindBy(css = "")
    public Link version;

    @FindBy(css = ".s-footer-nav-item-about")
    public Link aboutFooter;

    @FindBy(css = "s-footer-nav-item-legal")
    public Link tosFooter;

    @FindBy(css = ".s-footer-nav-item-privacy")
    public Link privacyFooter;

}
