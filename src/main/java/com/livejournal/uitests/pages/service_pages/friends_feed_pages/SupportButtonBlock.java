package com.livejournal.uitests.pages.service_pages.friends_feed_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
public class SupportButtonBlock extends UIBlock {

    @FindBy(css = "a[href*='/customize/#feed']")
    private Button settings;

    public Button getSettings() {
        return settings;
    }

}
