package com.livejournal.uitests.pages.service_pages.create_account_pages;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.UIBlock;
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

    // тут надо вставить все ссылочки, которые есть 
    // на форме удачного создания аккаунта
    @FindBy(id = "createpage_post")
    private Button createFirstPostButton;

    @FindBy(css = ".b-createpage-welcome")
    private WebElement finishText;

    // тут надо вставить все ссылочки, которые есть 
    // на форме неудачного создания аккаунта (меньше 13) 
    public Button getCreateFirstPostButton() {
        return elem(createFirstPostButton);
    }

    public WebElement getFinishText() {
        return elem(finishText);
    }

}
