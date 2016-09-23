package com.livejournal.uitests.pages.service_pages.medius.admin.update;

import com.livejournal.uitests.pages.LJPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@DefaultUrl("/admin/medius/")
public class ListOfPost extends LJPage {


    public boolean postIsExistInList(ColumnsListOfPost value) {
        ArrayList<WebElement> columns = new ArrayList<>();
        columns = (ArrayList<WebElement>) getDriver().findElements(By.xpath("//table//tr[@class='admintable__row' and position()=2]/descendant::td"));
        boolean subject = columns.get(1).findElement(By.xpath("//a[contains(text(),'" + value.getSubject() + "')]")).isDisplayed();
        boolean editor = columns.get(4).findElement(By.xpath("//span[@data-ljuser='" + value.getEditor() + "']")).isDisplayed();
        boolean status = columns.get(10).findElement(By.xpath("//div[contains(text(),'" + value.getStatus() + "')]")).isDisplayed();
        boolean authors = true;
        boolean interesting = true;
        boolean listPosition = true;
        ArrayList<String> source = value.getAuthors();
        for (int i = 0; i < source.size(); i++) {
            authors = authors && columns.get(5).findElement(By.xpath("//div[@class='admin-post-user']//span[@data-ljuser='" + source.get(i) + "']")).isDisplayed();
        }
        if (value.getInterestingPost()) {
            interesting = columns.get(6).findElement(By.xpath("//div//input[@type='checkbox' and @checked='checked']")).isDisplayed();
        }
        for (int i = 0; i < value.getPositionOnMainPage().size(); i++) {
            listPosition = listPosition && columns.get(8).findElement(By.xpath("//div[@class='admin-poststatus-title' and contains(text(), '" + value.getPositionOnMainPage().get(i) + "')]")).isDisplayed();
        }
        return subject && editor && status && authors && interesting  && listPosition;
    }

    public void openPost(String subject) {
        getDriver().findElement(By.xpath("//table//tr[@class='admintable__row' and position()=2]/descendant::td//a[contains(text(),'" + subject + "')]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ListOfPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        Set<String> handle = getDriver().getWindowHandles();
        getDriver().switchTo().window(handle.toArray()[1].toString());
    }

}