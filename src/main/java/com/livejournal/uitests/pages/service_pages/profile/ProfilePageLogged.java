package com.livejournal.uitests.pages.service_pages.profile;

import com.livejournal.uisteps.thucydides.elements.TextField;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author s.savinykh
 */@DefaultUrl("/profile")
public class ProfilePageLogged extends ServicePageLogged{
    
   @FindBy(css = ".b-profile-group-body")
    private TextField nameLabel;
    
    public String getName() {
        return this.startScript("return jQuery('.b-profile-group.b-profile-userinfo .b-profile-group-row .b-profile-group-body').eq(0).text()").toString();
    }
}
