/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

import com.livejournal.uisteps.thucydides.elements.Link;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-feedsettings-block-feed"))
public class FeedSettingsBlock {

    @FindBy(css = ".b-feedsettings-action-bg-image")
    private Link backgroundImage;

}
