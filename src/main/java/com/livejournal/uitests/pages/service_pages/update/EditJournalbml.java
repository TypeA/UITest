package com.livejournal.uitests.pages.service_pages.update;

import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/editjournal.bml")
public class EditJournalbml extends ServicePageLogged {

    @FindBy(name = "privacy")
    private Select privacySelect;

    @StepGroup
    public String getCurrentPrivacy() {
        
        String text = privacySelect.getFirstSelectedOption().getText();
        System.out.println("====================" + text);
        return text;
    }

}
