package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.searchMenu;

import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = SearchMenu.CSS))
public class SearchMenu extends UIBlock {

    final static String CSS = ".i-iconus-search";

    @FindBy(css = ".s-search #SearchText")
    public TextField searchLine;

}
