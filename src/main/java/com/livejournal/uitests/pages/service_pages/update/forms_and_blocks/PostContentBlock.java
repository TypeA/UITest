package com.livejournal.uitests.pages.service_pages.update.forms_and_blocks;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
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
public class PostContentBlock extends UIBlock {

    @FindBy(id = "subject")
    public TextField subjectField;

    @FindBy(css = "body[class=lj-main-body]")
    public TextField postVisualField;

    @FindBy(css = ".b-updateform-textarea")
    public TextField postHtmlField;

    @FindBy(css = ".b-updatepage-tab-visual")
    public Button visualEditButton;

    @FindBy(css = ".b-updatepage-tab-html")
    public Button htmlEditButton;

    @FindBy(id = "tags")
    public TextField tagsField;

    @FindBy(name = "privacy")
    public Select privacySelect;


    @StepGroup
    public void createPost(String subject, String editorType, String text) {
        if (subject.toUpperCase().equals("NO SUBJECT")) {
            subjectField.enter("");
        } else {
            subjectField.enter(subject);
        }
        switch (editorType.toUpperCase()) {
            case "VISUAL":
                visualEditButton.click();
                postVisualField.enter(text);
                break;
            case "HTML":
                htmlEditButton.click();
                postHtmlField.enter(text);
                break;
            default:
                Assert.fail("Unknown edit type " + editorType + "!");
        }
    }

    @StepGroup
    public void setSubject(String subject) {
        if (subject.toUpperCase().equals("NO SUBJECT")) {
        } else {
            subjectField.enter(subject);
        }
    }

    @StepGroup
    public void setText(String text, String editorType) {
        switch (editorType.toUpperCase()) {
            case "VISUAL":
                visualEditButton.click();
                postVisualField.enter(text);
                break;
            case "HTML":
                htmlEditButton.click();
                postHtmlField.enter(text);
                break;
            default:
                Assert.fail("Unknown edit type " + editorType + "!");
        }
    }

    @StepGroup
    public void setPrivacy(String privacy, ArrayList<String> group){
        privacySelect.selectByVisibleText(privacy);
        if (privacy.equals("Custom")) {
            for (String group1 : group) {
                this.startScript("jQuery(\"label:contains('" + group1 + "')\").click()");
            }
        }
    }

    @StepGroup
    public void setTags(String tags) {
        tagsField.enter(tags);
    }

    public ArrayList<String> getAllPrivacy() {
        List<WebElement> allSecurity = privacySelect.getOptions();
        ArrayList<String> privasy = new ArrayList<>();
        for (int i = 0; i < allSecurity.size(); i++) {
            privasy.add(allSecurity.get(i).getText());
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
        } else {
            return text;
        }
        return text;
    }
 
    @StepGroup
    public String getPostSubject() {
        String subject = startScript("return jQuery('#subject').val()").toString();
        if (subject.equals("")) {
            subject = "No subject";
        }
        return subject;
    }
}
