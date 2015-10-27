package com.livejournal.uitests.pages.service_pages.lj_magazine_page;

import com.livejournal.uitests.pages.service_pages.ServicePageLogged;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

/**
 *
 * @author s.savinykh
 */
@DefaultUrl("/magazine")
public class LJMagazinePageLogged extends ServicePageLogged {

    public Boolean categoryExistOnLJMagagazine(boolean usual_category, String name, String keyword) {
        if (usual_category) {
            System.out.println("usual");
            return getDriver().findElement(By.xpath("//ul[@class='discovery-categories__list']//a[@href[contains(.,'/magazine/category/" + keyword + "')] and contains(.,'" + name + "')]")).isDisplayed();
        } else {
            System.out.println("special");
            return getDriver().findElement(By.xpath("//ul[@class='special-categories__list']//a[@href[contains(.,'/magazine/category/" + keyword + "')] and contains(.,'" + name + "')]")).isDisplayed();
        }
    }

    public Boolean announceIsExistOnLJMagazine(String linksPost, String subject,String leadPost, String image) {
        boolean linkTopost = getDriver().findElement(By.xpath("//ul[@class='discovery__promo-post']//a[@href='"+linksPost+"']")).isDisplayed();
        boolean tittle = getDriver().findElement(By.xpath("//ul[@class='discovery__promo-post']//div//h3[@class='discovery-promo-post__title' and contains(.,'"+subject+"')]")).isDisplayed();
        boolean lead =  getDriver().findElement(By.xpath("/ul[@class='discovery__promo-post']//div//p[@class='discovery-promo-post__lead' and contains(.,'"+leadPost+"')]")).isDisplayed();
        boolean picture = getDriver().findElement(By.xpath("//ul[@class='discovery__promo-post']//div/img[@src='"+image+"']")).isDisplayed();
        return linkTopost&&tittle&&lead&&picture;
        
    }
}
