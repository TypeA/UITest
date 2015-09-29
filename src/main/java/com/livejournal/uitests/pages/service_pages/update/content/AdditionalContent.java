package com.livejournal.uitests.pages.service_pages.update.content;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-updatepage"))
public class AdditionalContent extends UpdateBmlBlockes {

    @FindBy(id = "sticky_type")
    public Button subjectField;

    public AdditionalContent setStickyPost() {
        subjectField.click();
        return this;
    }

    public Boolean getStickyPost() {
        return subjectField.isSelected();
    }

    @FindBy(id = "prop_current_mood")
    public TextField mood;

    @FindBy(id = "prop_current_music")
    public TextField music;

    @FindBy(id = "location")
    public TextField location;

    public AdditionalContent setRightBlockContent(String type, String content) {
        selestRightBlockContent(type).enter(content);
        return this;
    }

    public String getRightBlockContent(String type) {
        return startScript("return jQuery('.b-updatepage-input.b-updatepage-input-"
                + type.toLowerCase() + "').val()").toString();
    }

    private TextField selestRightBlockContent(String type) {
        switch (type.toUpperCase()) {
            case "MOOD":
                return mood;
            case "MUSIC":
                return music;
            case "LOCATION":
                return location;
            default:
                Assert.fail("Unknown right block type " + type + "!");
                return null;
        }
    }

}
