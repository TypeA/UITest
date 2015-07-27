package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.findMoreMenu;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */@Block(
        @FindBy(css = ".s-header-sub-list--find-more"))
public class FindMoreMenu extends UIBlock{
     
     @FindBy(css=".s-header-sub-list-item__link--community")
     public Link browse;
     
     @FindBy(css=".s-header-sub-list-item__link--rss")
     public Link rss;
    
}
