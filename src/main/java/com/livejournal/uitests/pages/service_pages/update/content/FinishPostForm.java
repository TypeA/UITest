package com.livejournal.uitests.pages.service_pages.update.content;

import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.tools.SheduledEntriesPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-panel.b-updatepage-result"))
public class FinishPostForm extends UIBlock {

    @FindBy(css = ".b-updatepage-result-status a")
    private Link scheduledLink;

    public SheduledEntriesPage clickToScheduledLink() {
        scheduledLink.click();
        return onOpened(SheduledEntriesPage.class);
    }

}
