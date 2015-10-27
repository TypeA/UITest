/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.lj_magazine_page.admin_lj_magazine;

import com.livejournal.uisteps.thucydides.elements.Button;
import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author m.panferova
 */
@DefaultUrl("/admin/magazine/announce")
public class AnnouncePage extends ServicePageLogged {

    @FindBy(name = "save")
    private Button saveSlots;

    @StepGroup
    public void editSlot(int slotId, String image, String post, String subject, String lead) {
        getDriver().findElement(By.xpath("//li//div//input[@name='main' and @value='"+slotId+"']")).click();
        getDriver().findElement(By.xpath("//li[@class='b-discoveryannouncements-item ng-scope']//textarea[@name='image_" + slotId + "']")).clear();
        getDriver().findElement(By.xpath("//li[@class='b-discoveryannouncements-item ng-scope']//textarea[@name='image_" + slotId + "']")).sendKeys(image);
        getDriver().findElement(By.xpath("//li[@class='b-discoveryannouncements-item ng-scope']//textarea[@name='post_" + slotId + "']")).clear();
        getDriver().findElement(By.xpath("//li[@class='b-discoveryannouncements-item ng-scope']//textarea[@name='post_" + slotId + "']")).sendKeys(post);
        getDriver().findElement(By.xpath("//li[@class='b-discoveryannouncements-item ng-scope']//textarea[@name='subject_" + slotId + "']")).clear();
        getDriver().findElement(By.xpath("//li[@class='b-discoveryannouncements-item ng-scope']//textarea[@name='subject_" + slotId + "']")).sendKeys(subject);
        getDriver().findElement(By.xpath("//li[@class='b-discoveryannouncements-item ng-scope']//textarea[@name='lead_" + slotId + "']")).clear();
        getDriver().findElement(By.xpath("//li[@class='b-discoveryannouncements-item ng-scope']//textarea[@name='lead_" + slotId + "']")).sendKeys(lead);
        clickSaveSlots();
    }

    public void clickSaveSlots() {
        saveSlots.click();
    }
    

}
