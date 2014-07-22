package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uitests.pages.UIBlock;
import com.livejournal.uitests.pages.service_pages.ServicePage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author m.prytkova
 */


/*@DefaultUrl("/legal/tos-russian-translation.bml")
public class PrivacyRusPage extends ServicePage{
    
}*/
@Block(
@FindBy(css = "body"))
public class PrivacyRusPage extends UIBlock{
    
}
