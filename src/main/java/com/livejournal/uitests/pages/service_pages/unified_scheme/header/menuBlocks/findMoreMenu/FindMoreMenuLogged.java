/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.findMoreMenu;

import com.livejournal.uitests.pages.browse.BrowseMainPageLogged;
import com.livejournal.uitests.pages.rss.RssPageLogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = ".s-header-sub-list--find-more"))
public class FindMoreMenuLogged extends FindMoreMenu {

    @StepGroup
    public BrowseMainPageLogged clickOnBrowse() {
        browse.click();
        return onOpened(BrowseMainPageLogged.class);
    }

    @StepGroup
    public RssPageLogged clickOnRss() {
        rss.click();
        return onOpened(RssPageLogged.class);
    }

}
