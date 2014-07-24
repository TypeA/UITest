/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.main_pages;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uitests.pages.service_pages.ServicePage;
import com.livejournal.uitests.pages.service_pages.Unified_scheme.header.FullscreenHeader;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/")//мне кажется, не так
public class MainPage extends ServicePage {

    //дополнительная страница, надо переделать
    @FindBy(xpath = ".//*[@href[contains(.,'/login.bml')]]")
    private Link enterLink;

    private FullscreenHeader fullscreenHeader;

    public Link getEnterLink() {
        return elem(enterLink);
    }

    public FullscreenHeader getFullscreenHeader() {
        return elem(fullscreenHeader);
    }
}
