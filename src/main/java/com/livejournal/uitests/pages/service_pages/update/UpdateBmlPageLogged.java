package com.livejournal.uitests.pages.service_pages.update;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.settings.SettingsMainPage;
import java.util.ArrayList;
import java.util.List;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/update.bml")
public class UpdateBmlPageLogged extends ServicePageLogged {

    @FindBy(id = "subject")
    private TextField subjectField;

    @FindBy(css = "[.lj-main-body")
    private TextField postVisualField;

    @FindBy(css = ".b-updateform-textarea")
    private TextField postHtmlField;

    @FindBy(name = "privacy")
    private Select privacySelect;

    @FindBy(name = "action:update")
    private Button addPostButton;

    @FindBy(css = ".b-updatepage-tab-visual")
    private Button visualEditButton;

    @FindBy(css = ".b-updatepage-tab-html")
    private Button htmlEditButton;

    /////////////////////////// draft
    @FindBy(css = ".b-popup.b-popupus.b-popupus-blue.b-popupus-confirm[style*='position'] .i-popup-close")
    private UIElement closeDraftButton;

    @FindBy(name = "dialog-ok")
    private Button restoreDraft;

    @StepGroup
    public UpdateBmlPageLogged createPost(String subject, String editorType, String text) {
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
        return onOpened(UpdateBmlPageLogged.class);
    }

    @StepGroup
    public UpdateBmlPageLogged setPrivacy(String privacy, String group) {
        privacySelect.selectByVisibleText(privacy);
        if (privacy.equals("Custom")) {
            this.startScript("jQuery(\"label:contains('" + group + "')\").click()");
        }
        return onOpened(UpdateBmlPageLogged.class);
    }

    @StepGroup
    public void postEntry() {
        addPostButton.click();
    }

    @StepGroup
    public UpdateBmlPageLogged closeDraft() {
        try {
            closeDraftButton.click();
            return onOpened(UpdateBmlPageLogged.class);
        } catch (Exception ex) {
            return onOpened(UpdateBmlPageLogged.class);
        }
    }

    @StepGroup
    public UpdateBmlPageLogged restoreFromDraft() {
        restoreDraft.click();
        return onOpened(UpdateBmlPageLogged.class);

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
}
