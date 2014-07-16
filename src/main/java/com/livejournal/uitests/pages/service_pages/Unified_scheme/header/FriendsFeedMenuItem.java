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
        (@FindBy(css=".s-nav-item.s-nav-item-sub.s-drop-master.s-nav-item-friends"))
public class FriendsFeedMenuItem extends UIBlock 
{
    @FindBy(css=".s-nav-rootlink-feed")
    public Link friendsFeed; 
    
    @FindBy(css=".s-nav-item-editgroups")
    public Link mngGroups;     
    
    @FindBy(css=".s-nav-item-edit")
    public Link mngFriends;   
        
    @FindBy(css=".s-nav-item-manage")
    public Link mngCommunities;     
    
    @FindBy(css=".s-nav-item-banusers")
    public Link bannedUsers;     
    
}
