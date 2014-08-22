package com.livejournal.uitests.pages.service_pages.friends_feed_pages.settings;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-feedsettings-block"))
public class PangingTypeSettingsBlock extends UIBlock{

    @FindBy(css = "select[ng-model*='paging_type']")
    private Select pageType;

    @FindBy(css = "input[ng-model*='paging_size']")
    private Select pageSize;

    public Select getPageType() {
        return pageType;
    }

    public Select getPageSize() {
        return pageSize;
    }

}
