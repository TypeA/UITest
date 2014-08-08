package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.UIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block
        (@FindBy(css=".s-nav-rootlink.s-nav-rootlink-support"))
public class HelpMenuItem extends UIElement 
{

    public HelpMenuItem(WebElement wrappedElement) 
    {
        super(wrappedElement);
    }

    @Override
    public HelpMenu moveMouseOver() 
    {
        super.moveMouseOver(); 
        return on(HelpMenu.class);
    }
    
}
