package com.livejournal.uitests.pages.service_pages.unified_scheme.header.menuBlocks.searchMenu;

import com.livejournal.uitests.pages.service_pages.search.SearchPageUnlogged;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author s.savinykh
 */
@Block(
        @FindBy(css = SearchMenu.CSS))
public class SearchMenuUnlogged extends SearchMenu {

    @StepGroup
    public SearchPageUnlogged search(String text) {
        searchLine.enter(text);
        Actions actions = new Actions(this.getDriver());
        actions.keyDown(Keys.ENTER).build().perform();
        return onOpened(SearchPageUnlogged.class);

    }
}
