package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.UIBlock;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-panel-step2"))
public class FinishForm extends UIBlock {

    @FindBy(css = ".b-createpage-welcome")
    private WebElement finishText;

    public WebElement getFinishText() {
        return finishText;
    }

}
