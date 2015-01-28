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
