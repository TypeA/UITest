package com.livejournal.uitests.pages.service_pages.update;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.Link;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.update.bubbles.LJUserBubble;
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

    @FindBy(name = "privacy")
    public Select privacySelect;

    @FindBy(css = ".b-updateform-button.b-updateform-button-user")
    private Link ljUserBubbleButton;

    private LJUserBubble ljuserBubble;

    @StepGroup
    public void createPost(String subject, String editorType, String text) {
        subjectField.enter(subject);
        switch (EditPostType.valueOf(editorType.toUpperCase())) {
            case VISUAL:
                visualEditButton.click();
                postVisualField.enter(text);
                break;
            case HTML:
                htmlEditButton.click();
                postHtmlField.enter(text);
                break;
            default:
                Assert.fail("Unknown edit type " + editorType + "!");
        }
    }

    @StepGroup
    public void setPrivacy(String privacy, ArrayList<String> group) throws InterruptedException {
        Thread.sleep(2500);
        privacySelect.selectByVisibleText(privacy);
        if (privacy.equals("Custom")) {
            for (int i = 0; i < group.size(); i++) {
                this.startScript("jQuery(\"label:contains('" + group.get(i) + "')\").click()");
            }
        }
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
    public LJUserBubble openLJUserBubble() {
        ljUserBubbleButton.click();
        return onDisplayed(LJUserBubble.class);
    }
    

}
