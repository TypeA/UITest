package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
/*@DefaultUrl("/legal/tos-russian-translation.bml")
 public class PrivacyRusPage extends ServicePage{
    
 }*/
@Block(
        @FindBy(css = "body"))
public class PrivacyRusPage extends UIBlock {

}
