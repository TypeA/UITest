package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.helpMenu;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = HelpMenu.CSS))

public class HelpMenu extends UIBlock {

    final static String CSS = ".s-nav-item-help .s-drop";

    @FindBy(css = ".s-nav-item-mobile.s-nav-rootlink-support a")
    protected Link help;

    @FindBy(css = ".s-nav-item-about a")
    protected Link about;

    @FindBy(css = ".s-nav-item-faq a")
    protected Link faq;

    @FindBy(css = ".s-nav-item-legal a")
    protected Link tos;

    @FindBy(css = ".s-nav-item-privacy a")
    protected Link privacy;

    @FindBy(css = ".s-nav-item-dmca a")
    protected Link dmca;

    @FindBy(css = ".s-nav-item-search #SearchText")
    protected TextField searchLine;

}
