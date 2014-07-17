/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */
public class FullscreenHeaderLogged extends FullscreenHeader
{
    
    public FriendsFeedMenuItem friendsFiedMenuItem;
    
    public MyJournalMenuItem myJournalMenuItem;
    
    @FindBy(css=".s-do-item.s-do-item-post")
    public Link postNewEntry;
    
    @FindBy(css=".s-do-item.s-do-item-message")
    public Link Messages;
    
    public ShopLogged shopLogged;
    
}
