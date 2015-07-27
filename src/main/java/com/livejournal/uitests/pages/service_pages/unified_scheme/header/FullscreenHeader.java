package com.livejournal.uitests.pages.service_pages.unified_scheme.header;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = FullscreenHeader.CSS))
public class FullscreenHeader extends UIBlock {

    final static String CSS = ".s-header";

    @FindBy(css = ".s-logo")
    protected Link logo;

    @FindBy(css = ".s-header-item__link--magazine")
    protected Link ljMagazineMenuItem;
    
    @FindBy(css = ".s-header-item__link--find-more")
    protected Link interestingMenuItem;

    @FindBy(css = ".s-nav-rootlink-shop")
    protected Link shopMenuItem;
}
