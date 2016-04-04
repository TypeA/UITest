package com.livejournal.uitests.pages.service_pages.profile;

import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
import java.util.ArrayList;
import net.thucydides.core.annotations.DefaultUrl;

/**
 *
 * @author p.kulich
 */
@DefaultUrl("/profile")
public class ProfilePageUnlogged extends ServicePageUnlogged {

    public String getProfileBirthday() {
        return this.startScript("return jQuery('.b-profile-group-row .b-profile-group-body').eq(1).text()").toString();
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
