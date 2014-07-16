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
        (@FindBy(css=".s-logo"))
public class Logo extends UIBlock
{
    @FindBy(xpath=".//div[@class='s-logo']/a")
    public Link LogoPic;
    
    @FindBy(xpath=".//div[@class='s-logo']/sup/a")
    public Link TestPic;
}