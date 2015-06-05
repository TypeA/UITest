package com.livejournal.uitests.pages.service_pages.update.content;

import com.livejournal.uisteps.thucydides.elements.Button;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-updatepage"))
public class AdditionalContent extends UpdateBmlBlockes {

    @FindBy(id = ".b-updatepage-checkbox-sticky")
    public Button subjectField;

    public AdditionalContent setStickyPost() {
        subjectField.click();
        return this;
    }

}
