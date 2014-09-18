package com.livejournal.uitests.pages.service_pages.unified_scheme.header.MenuBlocks;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
/**
 *
 * @author s.savinykh
 */
@Block
        (@FindBy(css=".b-popup-withclosecontrol[style*='visible']"))
public class FeedbackMenu extends UIBlock 
{
     
    @FindBy(css=".i-popup-close") 
    public Link xButton;
    
    @FindBy(css=".s-welcometo-action")
    public Link sendFeedback;
    
    @FindBy(css=".s-welcometo-switch")
    public Link switchOld;
    
}
