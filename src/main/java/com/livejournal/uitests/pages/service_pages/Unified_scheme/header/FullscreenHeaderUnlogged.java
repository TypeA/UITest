/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import net.thucydides.core.annotations.findby.FindBy;

/**
 *
 * @author s.savinykh
 */
public class FullscreenHeaderUnlogged extends FullscreenHeader
{
    public ShopMenuItem shopMenuItem;
    
    @FindBy(css=".s-nav-item.s-nav-item-login")
    public Link loginMenuItem;
    
    public LangSwitch langSwitch;
  
   
}
