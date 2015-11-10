/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livejournal.uitests.pages.service_pages.lj_magazine_page;

import com.livejournal.uitests.pages.service_pages.ServicePage;
import com.livejournal.uitests.pages.service_pages.error_strip.ErrorStrip;
import com.livejournal.uitests.pages.service_pages.unified_scheme.header.FullscreenHeader;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.StepGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/magazine/")
public class LJMagazinePage extends ServicePage {

    public String getPostID() {
        return getDriver().getCurrentUrl().replace("http://www." + getSystemConfiguration().getBaseUrl() + "/magazine/", "");
    }

    public String getStatusOfAddAsFriendButton() {
        String status = "enabled";
        if (startScript("return jQuery('.b-discoveryarticle-addfriend-title').attr(\"lj-ml\")").equals("discovery.article.addfriend.added")) {
            status = "disabled";
        }
        return status;
    }

    @StepGroup
    public String getAuthorOfThePost() {
        return startScript("return jQuery('.b-discoveryarticle-v5 .i-ljuser-username').text()").toString();
    }

    @StepGroup
    public LJMagazinePage addAsFriend() {
        startScript("jQuery('.b-discoveryarticle-addfriend-title').click()");
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return onOpened(LJMagazinePage.class).getStatusOfAddAsFriendButton().equals("disabled");
            }
        });
        return this;
    }

    @StepGroup
    public LJMagazinePage openRandomPost(String authorOfPost) {
        boolean flag = true;
        int page = 1;
        while (flag) {
            try {
                if (authorOfPost.equals("ljEditor")) {
                    startScript("jQuery(\"a.i-ljuser-username:contains('Журнал ЖЖ')\").parents('.entryunit').find('.entryunit__head a')[0].click()");
                } else {
                    startScript("jQuery(\"a.i-ljuser-username:not(:contains('Журнал ЖЖ'))\").parents('.entryunit').find('.entryunit__head a')[0].click()");
                }
                flag = false;
            } catch (Exception ex) {
                if (page > 10) {
                    flag = false;
                } else {
                    page++;
                }
            }
        }
        return this;
    }

    public Boolean categoryExistOnLJMagagazine(boolean usual_category, String name, String keyword) {
        if (usual_category) {
            System.out.println("usual");
            return getDriver().findElement(By.xpath("//ul[@class='discovery-categories__list']//a[@href[contains(.,'/magazine/category/" + keyword + "')] and contains(.,'" + name + "')]")).isDisplayed();
        } else {
            System.out.println("special");
            return getDriver().findElement(By.xpath("//ul[@class='special-categories__list']//a[@href[contains(.,'/magazine/category/" + keyword + "')] and contains(.,'" + name + "')]")).isDisplayed();
        }
    }

    public Boolean announceIsExistOnLJMagazine(String linksPost, String subject, String leadPost, String image) {
        boolean linkTopost = getDriver().findElement(By.xpath("//ul[@class='discovery__promo-post']//a[@href='" + linksPost + "']")).isDisplayed();
        boolean tittle = getDriver().findElement(By.xpath("//ul[@class='discovery__promo-post']//div//h3[@class='discovery-promo-post__title' and contains(.,'" + subject + "')]")).isDisplayed();
        boolean lead = getDriver().findElement(By.xpath("/ul[@class='discovery__promo-post']//div//p[@class='discovery-promo-post__lead' and contains(.,'" + leadPost + "')]")).isDisplayed();
        boolean picture = getDriver().findElement(By.xpath("//ul[@class='discovery__promo-post']//div/img[@src='" + image + "']")).isDisplayed();
        return linkTopost && tittle && lead && picture;

    }

    @Override
    public FullscreenHeader getFullscreenHeader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ErrorStrip getErrorStrip() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
