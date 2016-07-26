package com.livejournal.uitests.pages.service_pages.medius.admin.update;

import com.livejournal.uisteps.thucydides.elements.UIElement;
import com.livejournal.uitests.pages.LJPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("/admin/medius/preview")
public class PreviewPost extends LJPage {

    @FindBy(css = "div.mdspost-meta-author a.i-ljuser-username")
    private UIElement authorLJMedia;

    public boolean authorLJMediaExist(){
        return authorLJMedia.isDisplayed();
    }

    public boolean subjectLeadBodyExist(String subjectText, String leadText){
        boolean subject = getDriver().findElement(By.xpath("//h1[@class='mdspost-title']/span[@class='mdspost-title__text' and contains(text(), ' "+subjectText+" ')]")).isDisplayed();
        boolean lead = getDriver().findElement(By.xpath("//div[@class='mdspost-brief' and contains(text(), '"+leadText+"')]")).isDisplayed();
        String body = getDriver().findElement(By.cssSelector("div.mdspost-text.ng-scope")).getText();
        return subject;
    }



}