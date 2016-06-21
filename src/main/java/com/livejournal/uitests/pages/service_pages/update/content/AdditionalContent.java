package com.livejournal.uitests.pages.service_pages.update.content;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.CheckBox;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-updatepage"))
public class AdditionalContent extends UpdateBmlBlockes {

    @FindBy(id = "sticky_type")
    public Button stickyType;

    public AdditionalContent setStickyPost() {
        stickyType.click();
        return this;
    }

    public Boolean getStickyPost() {
        return stickyType.isSelected();
    }

    @FindBy(id = "prop_current_mood")
    public TextField mood;

    @FindBy(id = "prop_current_music")
    public TextField music;

    @FindBy(id = "location")
    public TextField location;

    public AdditionalContent setRightBlockContent(String type, String content) {
        selectRightBlockContent(type).enter(content);
        return this;
    }

    public String getRightBlockContent(String type) {
        return startScript("return jQuery('.b-updatepage-input.b-updatepage-input-"
                + type.toLowerCase() + "').val()").toString();
    }

    private TextField selectRightBlockContent(String type) {
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

    @FindBy(css = ".lj-widget-22")
    private CheckBox feedRssIgnore;

    @FindBy(css = ".lj-widget-24")
    private CheckBox ignoreRatings;

    public AdditionalContent setFoRIgnore(String checkbox) {
        if (checkbox.toLowerCase().equals("feedandrss")) {
            feedRssIgnore.select();
        } else if (checkbox.toLowerCase().equals("ratings")) {
            ignoreRatings.select();
        }
        return this;
    }

    public Boolean getFoRIgnore(String checkbox) {
        System.out.println("=============== " + feedRssIgnore.isSelected());

        return feedRssIgnore.isSelected();
    }

    @FindBy(css = ".b-updatepage-threeposts-check")
    private CheckBox threePosts;

    public AdditionalContent setThreePosts() {
        if (!threePosts.isSelected()) {
            threePosts.select();
        }
        return this;
    }

    public Boolean getThreePosts() {
        return threePosts.isSelected();
    }

}
