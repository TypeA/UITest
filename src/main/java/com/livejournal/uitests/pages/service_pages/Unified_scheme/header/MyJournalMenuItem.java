/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livejournal.uitests.pages.service_pages.Unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */

@Block
        (@FindBy(css=".s-nav-item-user"))
public class MyJournalMenuItem extends UIBlock
{
    @FindBy(css="label[for='s-nav-body-user'] .s-userpic")
    public Link userPic;
    
    @FindBy(css=".s-nav-rootlink-blog")
    public Link myJournal;
    
    @FindBy(css=".s-nav-item-you")
    public Link authorizedAs;
    
    @FindBy(css=".s-nav-item-post")
    public Link newPost;
    
    @FindBy(css=".s-nav-item-profile")
    public Link profile;
    
    @FindBy(css=".s-nav-item-counter")
    public Link messagesInMenu;
    
    @FindBy(css=".s-nav-item-scheduled")
    public Link sheduledEntries;
    
    @FindBy(css=".s-nav-item-comments")
    public Link recentComments;
    
    @FindBy(css=".s-nav-item-statistics")
    public Link statictics;
    
    @FindBy(css=".s-nav-item-tags")
    public Link tags;
    
    @FindBy(css=".s-nav-item-customize")
    public Link journalStyle;
    
    @FindBy(css=".s-nav-item-settings")
    public Link settings;
    
    @FindBy(css=".s-nav-item-logout")
    public Link logOut;
    
}
