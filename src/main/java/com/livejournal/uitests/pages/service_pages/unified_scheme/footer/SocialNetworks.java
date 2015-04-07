package com.livejournal.uitests.pages.service_pages.unified_scheme.footer;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block
        (@FindBy(css=".s-social"))
public class SocialNetworks extends UIBlock
{
    @FindBy(css=".s-social-item-f")
    public Link Facebook;
    
    @FindBy(css=".s-social-item-tw")
    public Link Twitter;
    
    @FindBy(css=".s-social-item-vk")
    public Link VK;
    
    @FindBy(css=".s-social-item-gp")
    public Link Gplus;
    
}
