/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;


/**
 *
 * @author s.savinykh
 */
public class FullscreenHeader extends UIBlock
{
    
    public Logo logo;
    
    @FindBy(css=".s-nav-rootlink-discovery")
    public Link ljMagazine;
    
    public HelpMenuItem helpMenuItem;
    
    public FeedbackMenuItem feedback;
    
    public SearchMenuItem searchMenuItem;
    
}
