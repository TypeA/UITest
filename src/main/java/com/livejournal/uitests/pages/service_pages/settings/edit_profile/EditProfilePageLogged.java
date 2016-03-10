package com.livejournal.uitests.pages.service_pages.settings.edit_profile;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import java.util.ArrayList;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/manage/profile/?authas=")
public class EditProfilePageLogged extends ServicePageLogged {
    
    @FindBy(css = ".b-standout.manage-profile__save button")
    private Button flatButton;
    
    public EditProfilePageLogged saveSettings() {
        flatButton.click();
        return this;
    }
    
    public EditProfilePageLogged setBirthdayPrivacy(String privacy) {
        onDisplayed(IdentityBlock.class).setBirthdayPrivacy(privacy);
        return this;
    }

    public EditProfilePageLogged setName(String name) {
        onDisplayed(IdentityBlock.class).setProfileName(name);
        return this;
    }
    
    public String getName() {
        return onDisplayed(IdentityBlock.class).getProfileName();
    }
    
    public String getGender() {
        return onDisplayed(IdentityBlock.class).getGender();
    }
    
    public EditProfilePageLogged setGender(String gender) {
        onDisplayed(IdentityBlock.class).setGender(gender);
        return this;
    }
    
    public String getStickyError() {
        return getErrorStrip().getErrorText();
    }
    
    public EditProfilePageLogged setBirthday(String year, String month, String day) {
        onDisplayed(IdentityBlock.class).setBirthday(year, month, day);
        return this;
    }
    
    public EditProfilePageLogged setShowBDate(String param) {
        onDisplayed(IdentityBlock.class).setShowBDate(param);
        return this;
    }


    public EditProfilePageLogged setShowBirthdayPrivacy(String option) {
        onDisplayed(IdentityBlock.class).setShowBirthdayPrivacy(option);
        return this;
    }
    
    public ArrayList<String> getBirthday() {
        return onDisplayed(IdentityBlock.class).getBirthday();
    }
}
