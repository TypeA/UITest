package com.livejournal.uitests.pages.service_pages.profile;

import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

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
    
    public boolean BirthdayIsNotVisible() {
        String buf= startScript("return jQuery('.b-profile-group-subheader').eq(1).text()").toString();
        return !buf.equals("Birthdate"); 
    }
}
