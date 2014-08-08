package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
public class HelpMenu extends UIBlock {

    @FindBy(css = ".s-nav-item-mobile.s-nav-rootlink-support")
    private Help help;

    @FindBy(css = ".s-nav-item-about")
    private About about;

    @FindBy(css = ".s-nav-item-faq")
    private Faq faq;

    @FindBy(css = ".s-nav-item-legal")
    private Tos tos;

    @FindBy(css = ".s-nav-item-privacy")
    private Privacy privacy;

    @FindBy(css = ".s-nav-item-dmca")
    private Dmca dmca;

    @FindBy(css = ".s-nav-item-search #SearchText")
    private SearchLine searchLine;

    
    public Help getHelp() 
    {
        return elem(help);
    }
    public About getAbout() 
    {
        return about;
    }
    public Faq getFaq() 
    {
        return faq;
    }
    public Tos getTos() 
    {
        return tos;
    }
    public Privacy getPrivacy() 
    {
        return privacy;
    }
    public Dmca getDmca() 
    {
        return dmca;
    }
    public SearchLine getSearchLine() 
    {
        return searchLine;
    }

    
    public class Help extends UIElement 
    {
        public Help(WebElement wrappedElement) 
        {
            super(wrappedElement);
        }     
    }
        
    public class About extends UIElement
    {
        public About(WebElement wrappedElement) 
        {
            super(wrappedElement);
        }
    }
    
    public class Faq extends UIElement 
    {
        public Faq(WebElement wrappedElement) 
        {
            super(wrappedElement);
        }     
    }
        
    public class Tos extends UIElement 
    {
        public Tos(WebElement wrappedElement) 
        {
            super(wrappedElement);
        }     
    }
    
    public class Privacy extends UIElement 
    {
        public Privacy(WebElement wrappedElement) 
        {
            super(wrappedElement);
        }     
    }
    
    public class Dmca extends UIElement 
    {
        public Dmca(WebElement wrappedElement) 
        {
            super(wrappedElement);
        }     
    }
        
    public class SearchLine extends UIElement 
    {
        public SearchLine(WebElement wrappedElement) 
        {
            super(wrappedElement);
        }     
    }
    
}
