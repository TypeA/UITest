package com.livejournal.uitests.pages.service_pages.profile;

import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uisteps.thucydides.elements.UIBlock;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import java.util.ArrayList;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/profile")
public class ProfilePageLogged extends ServicePageLogged {

    public String getProfileName() {
        return startScript("return jQuery('.b-profile-group.b-profile-userinfo"
                + " .b-profile-group-row .b-profile-group-body').eq(0).text()").toString();
    }

    public String getProfileBirthday() {
        return startScript("return jQuery('.b-profile-group-row .b-profile-group-body').eq(1).text()").toString();
    }

    public String getBirthdayLabel() {
        return startScript("return jQuery('.b-profile-group-subheader').eq(1).text()").toString();

    }
    
    public ArrayList<String> getSchoolList() {
        return onDisplayed(SchoolsBlock.class).getSchoolList();
    }

    public String getSchoolInfo() {
        String school = startScript("return jQuery('.b-profile-group-body .b-profile-list').eq(1).text()").toString();
        return school.trim();
    }

}
