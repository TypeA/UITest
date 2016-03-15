package com.livejournal.uitests.pages.service_pages.settings.edit_profile;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import com.livejournal.uitests.pages.service_pages.profile.ProfilePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.prytkova
 */
@DefaultUrl("/manage/profile/?authas=")
public class EditProfilePageLogged extends ServicePageLogged {

    @FindBy(css = ".b-flatbutton")
    private Button flatButton;

    public ProfilePageLogged saveSettings() {
        flatButton.click();
        return onOpened(ProfilePageLogged.class);
    }

    private IdentityBlock identityBlock;

    public EditProfilePageLogged setName(String name) {
        identityBlock.setName(name);
        return this;
    }

    public String getName() {
        return identityBlock.getName();
    }
/*
    public EditProfilePageLogged setGender(String gender) {
        identityBlock.setGender(gender);
        return this;
    }

    public EditProfilePageLogged setBirthday(String day, String month, String year) {
        identityBlock.setBirthday(day, month, year);
        return this;
    }*/

}
