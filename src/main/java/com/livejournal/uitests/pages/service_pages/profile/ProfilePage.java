package com.livejournal.uitests.pages.service_pages.profile;

import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("/profile")
public class ProfilePage extends ServicePageLogged{
    
     public boolean noteIsDisplayed(String userWithNote, String note){
     return getDriver().findElement(By.xpath("//span[@data-ljuser='"+userWithNote+"']"
             + "/a[@title='"+note+"']//following::span[contains(text(),'"+note+"')]")).isDisplayed();
     }
}
