package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block 
        (@FindBy(css=".s-nav-item-friends"))
public class FriendsFeedMenu extends UIBlock 
{
    @FindBy(css=".s-nav-rootlink-feed")
    private Link friendsFeed; 
    
    @FindBy(css=".s-nav-item-editgroups")
    private Link mngGroups;     
    
    @FindBy(css=".s-nav-item-edit")
    private Link mngFriends;   
        
    @FindBy(css=".s-nav-item-manage")
    private Link mngCommunities;     
    
    @FindBy(css=".s-nav-item-banusers")
    private Link bannedUsers;     
    
}
