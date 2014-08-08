package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.UIElement;
import org.openqa.selenium.WebElement;
/**
 *
 * @author s.savinykh
 */
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
