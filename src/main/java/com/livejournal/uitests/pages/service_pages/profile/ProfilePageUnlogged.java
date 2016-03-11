
package com.livejournal.uitests.pages.service_pages.profile;

import com.livejournal.uitests.pages.service_pages.ServicePageUnlogged;
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
    
    public boolean BirthdayIsNotVisible() {
        String buf= startScript("return jQuery('.b-profile-group-subheader').eq(1).text()").toString();
        return !buf.equals("Birthdate"); 
    }
    
}
