package com.livejournal.uitests.pages.service_pages.update.content;

import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.update.content.editors.HTMLEditor;
import com.livejournal.uitests.pages.service_pages.update.content.editors.VisualEditor;
import java.util.ArrayList;
import java.util.List;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author m.prytkova
 */
@Block(
        @FindBy(css = ".b-updatepage"))
public class PostContentBlock extends UpdateBmlBlockes {

    private VisualEditor visualEditor;

    private HTMLEditor htmlEditor;

    @StepGroup
    public PostContentBlock setPostText(String text, String editorType) {
        switch (editorType.toUpperCase()) {
            case "VISUAL":
                visualEditor.setPostText(text);
                break;
            case "HTML":
                htmlEditor.setPostText(text);
                break;
            default:
                Assert.fail("Unknown edit type " + editorType + "!");
        }
        return this;
    }

    @FindBy(id = "tags")
    public TextField tagsField;

    @StepGroup
    public PostContentBlock setTags(String tags) {
        tagsField.enter(tags);
        return this;
    }

    @FindBy(id = "subject")
    public TextField subjectField;

    @StepGroup
    public PostContentBlock setSubject(String subject) {
        if (subject.toUpperCase().equals("NO SUBJECT")) {
            subject = "";
        }
        subjectField.enter(subject);
        return this;
    }

    @StepGroup
    public String getSubject() {
        String subject = startScript("return jQuery('#subject').val()").toString();
        if (subject.equals("")) {
            subject = "No subject";
        }
        return subject;
    }

    @FindBy(name = "privacy")
    public Select privacySelect;

    @StepGroup
    public PostContentBlock setPrivacy(String privacy, ArrayList<String> group) {
        privacySelect.selectByVisibleText(privacy);
        if (privacy.equals("Custom")) {
            for (String group1 : group) {
                startScript("jQuery(\"label:contains('" + group1 + "')\").click()");
            }
        }
        return this;
    }

    public ArrayList<String> getAllPrivacy() {
        List<WebElement> allSecurity = privacySelect.getOptions();
        ArrayList<String> privasy = new ArrayList<>();
        for (WebElement allSecurity1 : allSecurity) {
            privasy.add(allSecurity1.getText());
        }
        return privasy;
    }

    @StepGroup
    public String getCurrentPrivacy() {
        String text = privacySelect.getFirstSelectedOption().getText();
        if (text.equals("Custom")) {
            Integer size = Integer.valueOf(startScript("return jQuery('.privacy-item.ng-scope label input').size()").toString());
            for (Integer i = 1; i < size; i++) {
                if (startScript("return jQuery(\".privacy-item.ng-scope label input\").eq(" + i.toString() + ").is(':checked')").toString().equals("true")) {
                    text = text + "\n" + startScript("return jQuery(\".privacy-item.ng-scope label span\").eq(" + i.toString() + ").text()").toString();
                }
            }
        }
        return text;
    }

}
